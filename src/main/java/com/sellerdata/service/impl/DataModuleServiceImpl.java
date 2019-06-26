package com.sellerdata.service.impl;


import com.sellerdata.mapper.jpa.ModuleExcuteStatusMapper;
import com.sellerdata.mapper.mybatis.AmzRegionMapperEx;
import com.sellerdata.mapper.mybatis.ModuleSubscribeMapperEx;
import com.sellerdata.mapper.mybatis.SellerMapperEx;
import com.sellerdata.pojo.ModuleExcuteStatus;
import com.sellerdata.pojo.vo.AmzRegionVO;
import com.sellerdata.pojo.vo.DataModuleVO;
import com.sellerdata.pojo.vo.ModuleSubscribeVO;
import com.sellerdata.service.DataModuleService;
import com.sellerdata.util.entity.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class DataModuleServiceImpl implements DataModuleService {

    @Autowired
    SellerMapperEx sellerMapperEx;

    @Autowired
    AmzRegionMapperEx amzRegionMapperEx;

    @Autowired
    ModuleExcuteStatusMapper moduleExcuteStatusMapper;

    @Autowired
    ModuleSubscribeMapperEx moduleSubscribeMapperEx;

    @Override
    public ResultBean findDataModuleList(Integer brandId) {
        ResultBean resultBean = new ResultBean();
        if(brandId == null || brandId == 0){
            resultBean.setCode(500);
            resultBean.setMsg("请选择账号");
            return resultBean;
        }

        //显示区域list
        List<AmzRegionVO> amzRegionVOList =  amzRegionMapperEx.getAmzRegionVOList();

        List<DataModuleVO> dataModuleVOList =  sellerMapperEx.findDataModuleList(brandId);

        for (DataModuleVO dataModuleVO : dataModuleVOList){

            System.out.println("moduleName = " + dataModuleVO.getModuleName());
            System.out.println("SubscribeIdStr = " + dataModuleVO.getSubscribeIdStr());

            List<String> subscribeId = Arrays.asList(dataModuleVO.getSubscribeIdStr().split(","));

            List<ModuleSubscribeVO>  moduleSubscribeVOList  = sellerMapperEx.findModuleSubscribeVOList(subscribeId);
            System.out.println("List = " + moduleSubscribeVOList);

            //添加对应list
            dataModuleVO.setModuleSubscribeVOList(moduleSubscribeVOList);

        }
        resultBean.setData(dataModuleVOList);
        return resultBean;
    }

    @Override
    public ResultBean getAmzRegionVOList() {
        ResultBean resultBean = new ResultBean();

        List<AmzRegionVO> amzRegionVOList =  amzRegionMapperEx.getAmzRegionVOList();
        resultBean.setData(amzRegionVOList);

        return resultBean;
    }

    @Override
    public ResultBean getModuleExcuteStatusList() {
        ResultBean resultBean = new ResultBean();
        List<ModuleExcuteStatus> moduleSubscribeVOList = moduleExcuteStatusMapper.findAll();
        resultBean.setData(moduleSubscribeVOList);

        return resultBean;
    }


    @Transactional
    @Override
    public ResultBean updateSubscribeStatus(Integer subscribeId, Integer status) {
        ResultBean resultBean = new ResultBean();
        if(subscribeId == null || subscribeId == 0){
            resultBean.setCode(500);
            resultBean.setMsg("subscribeId 为空");
            return resultBean;
        }
        int num = moduleSubscribeMapperEx.updateSubscribeStatus(subscribeId,status);

        int excuteStatusId = 0;

        if(status == 1){
          if(num > 0){
              excuteStatusId = 101;
              int num1 = moduleSubscribeMapperEx.updateLastExecuteStatusId(subscribeId,excuteStatusId);
              if(num1 > 0){
                  resultBean.setMsg("启动成功");
              }else{
                  resultBean.setMsg("启动失败");
                  resultBean.setCode(500);
                  return resultBean;
              }
          }else{
              resultBean.setMsg("启动失败");
              resultBean.setCode(500);
              return resultBean;
          }

        }else if(status == 0){
            if(num > 0){
                excuteStatusId = 100;
               int num1 = moduleSubscribeMapperEx.updateLastExecuteStatusId(subscribeId,excuteStatusId);

                if(num1 > 0){
                    resultBean.setMsg("停止成功");
                }else{
                    resultBean.setMsg("停止失败");
                    resultBean.setCode(500);
                    return resultBean;
                }

            }else{
                resultBean.setMsg("停止失败");
                resultBean.setCode(500);
                return resultBean;
            }

        }

        return resultBean;
    }


}
