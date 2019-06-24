package com.sellerdata.service.impl;


import com.sellerdata.mapper.mybatis.SellerMapperEx;
import com.sellerdata.pojo.vo.DataModuleVO;
import com.sellerdata.service.DataModuleService;
import com.sellerdata.util.entity.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataModuleServiceImpl implements DataModuleService {



    @Autowired
    SellerMapperEx sellerMapperEx;

    @Override
    public ResultBean findDataModuleList(Integer brandId) {
        ResultBean resultBean = new ResultBean();
        if(brandId == null || brandId == 0){
            resultBean.setCode(500);
            resultBean.setMsg("请选择账号");
            return resultBean;
        }

        List<DataModuleVO> dataModuleVOList =  sellerMapperEx.findDataModuleList(brandId);
        resultBean.setData(dataModuleVOList);

        return resultBean;
    }
}
