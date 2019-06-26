package com.sellerdata.service.impl;

import com.sellerdata.mapper.jpa.AmzSellerMapper;
import com.sellerdata.mapper.jpa.AmzSellerMwsMapper;
import com.sellerdata.mapper.jpa.BrandMapper;
import com.sellerdata.mapper.jpa.UserMapper;
import com.sellerdata.mapper.mybatis.ModuleMapperEx;
import com.sellerdata.mapper.mybatis.ModuleSubscribeMapperEx;
import com.sellerdata.mapper.mybatis.SellerAccountMapperEx;
import com.sellerdata.mapper.mybatis.SellerMapperEx;
import com.sellerdata.pojo.*;
import com.sellerdata.pojo.vo.AmzSellerAccountVO;
import com.sellerdata.pojo.vo.SellerMwsVO;
import com.sellerdata.pojo.vo.SellerVO;
import com.sellerdata.service.SellerService;
import com.sellerdata.util.entity.ResultBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BrandMapper brandMapper;

    @Autowired
    AmzSellerMapper amzSellerMapper;

    @Autowired
    SellerMapperEx sellerMapperEx;

    @Autowired
    AmzSellerMwsMapper amzSellerMwsMapper;

    @Autowired
    SellerAccountMapperEx sellerAccountMapperEx;

    @Autowired
    ModuleSubscribeMapperEx moduleSubscribeMapperEx;

    @Autowired
    ModuleMapperEx moduleMapperEx;


    @Override
    public ResultBean findSellerList(Integer brandId) {
        ResultBean resultBean = new ResultBean();
        if(brandId == null || brandId == 0){
            resultBean.setCode(500);
            resultBean.setMsg("请选择账号");
            return resultBean;
        }

        List<SellerVO> sellerVoList = sellerMapperEx.findSellerList(brandId);

        resultBean.setData(sellerVoList);

        return resultBean;
    }

    @Transactional
    @Override
    public ResultBean saveSellerMwsVO(SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = new ResultBean();

        resultBean = checkSellMwsVO(sellerMwsVO);
        if(resultBean.getCode().equals(500)){
            return resultBean;
        }

      //  int sellerId = sellerMwsVO.getSellerId(); 前端传入的sellerId用来改变 amz_seller对应的状态

        int mwsId = sellerMwsVO.getMwsId();
        //1:先保存
        if(mwsId == 0){
            //新增
            sellerMapperEx.addSellerMws(sellerMwsVO);
            sellerMwsVO.setMwsId(sellerMwsVO.getMwsId());

            //1.1:判断是否存在对应 module_subscribe
            boolean flag = isExistModuleSubscribeByMwsId(sellerMwsVO.getMwsId());
            System.out.println("=== flag ===" + flag);

            if(!flag){
                //1.2不存在 进行新增 module_subscribe
                //通过 module_type 查询 module 列表
               // List<Integer> moduleIdList = moduleMapperEx.findModuleIdListByModuleType(1);
                List<Module> moduleList = moduleMapperEx.findModuleListByModuleType(1);

                if(moduleList == null || moduleList.size() == 0){
                    resultBean.setMsg("不存在对应模块,新增失败");
                    resultBean.setCode(500);
                    return resultBean;
                }


                ModuleSubscribe moduleSubscribe = new ModuleSubscribe();

                for(Module module : moduleList){
                    moduleSubscribe.setModuleId(module.getModuleId());
                    moduleSubscribe.setModuleSettings(module.getDefaultSetting());
                    moduleSubscribe.setMwsId(sellerMwsVO.getMwsId());
                    moduleSubscribe.setSellerId(sellerMwsVO.getSellerId());

                    //判断 是否已存在 moduleSubscribe
                 /*   boolean flag1 = isExistModuleSubscribeByMwsId(sellerMwsVO.getMwsId());
                    System.out.println("=== flag1 ===" + flag1);
                    if(!flag1){*/
                        moduleSubscribeMapperEx.addModuleSubscribe(moduleSubscribe);
                  //  }
                }
            }
            else{
                //1.3 存在 无操作
            }

        }else if(mwsId > 0){
            //修改
            sellerMapperEx.updateSellerMws(sellerMwsVO);
        }

        //2:改变状态
        int sellerId = sellerMwsVO.getSellerId();

        int num = sellerMapperEx.updateMwsStatus(sellerId);


        if(num > 0){
            resultBean.setMsg("保存成功");

        }else{
            resultBean.setCode(500);
            resultBean.setMsg("保存失败");
        }
        return resultBean;
    }

    private boolean isExistModuleSubscribeByMwsId(int mwsId) {
        boolean result = false;
       Integer num =  moduleSubscribeMapperEx.isExistModuleSubscribeByMwsId(mwsId);
        if(num  != null && num > 0){
            result = true;
        }

        return result;

    }

    @Transactional
    @Override
    public ResultBean saveSellerMwsAuth(SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = new ResultBean();

        resultBean = checkSellMwsAuthVO(sellerMwsVO);
        if(resultBean.getCode().equals(500)){
            return resultBean;
        }
        int mwsId = sellerMwsVO.getMwsId();
        //1:先保存
        if(mwsId == 0){
            //新增
            sellerMapperEx.addSellerMws(sellerMwsVO);
            sellerMwsVO.setMwsId(sellerMwsVO.getMwsId());

            //1.1:判断是否存在对应 module_subscribe
            boolean flag = isExistModuleSubscribeByMwsId(sellerMwsVO.getMwsId());
            System.out.println("=== flag ===" + flag);

            if(!flag){
                //1.2不存在 进行新增 module_subscribe
                //通过 module_type 查询 module 列表
                // List<Integer> moduleIdList = moduleMapperEx.findModuleIdListByModuleType(1);
                List<Module> moduleList = moduleMapperEx.findModuleListByModuleType(1);

                if(moduleList == null || moduleList.size() == 0){
                    resultBean.setMsg("不存在对应模块,新增失败");
                    resultBean.setCode(500);
                    return resultBean;
                }
                ModuleSubscribe moduleSubscribe = new ModuleSubscribe();

                for(Module module : moduleList){
                    moduleSubscribe.setModuleId(module.getModuleId());
                    moduleSubscribe.setModuleSettings(module.getDefaultSetting());
                    moduleSubscribe.setMwsId(sellerMwsVO.getMwsId());
                    moduleSubscribe.setSellerId(sellerMwsVO.getSellerId());

                    //判断 是否已存在 moduleSubscribe
                 /*   boolean flag1 = isExistModuleSubscribeByMwsId(sellerMwsVO.getMwsId());
                    System.out.println("=== flag1 ===" + flag1);
                    if(!flag1){*/
                    moduleSubscribeMapperEx.addModuleSubscribe(moduleSubscribe);
                    //  }
                }
            }
            else{
                //1.3 存在 无操作
            }

        }else if(mwsId > 0){
            //修改
            sellerMapperEx.updateSellerMws(sellerMwsVO);
        }

        //2:改变状态
        int sellerId = sellerMwsVO.getSellerId();

        int num = sellerMapperEx.updateEasybisonMwsStatus(sellerId);
        if(num > 0){
            resultBean.setMsg("保存成功");

        }else{
            resultBean.setCode(500);
            resultBean.setMsg("保存失败");
        }

        return resultBean;
    }

    @Override
    public ResultBean findSellerMwsBySellerId(Integer sellerId) {
        ResultBean resultBean = new ResultBean();

        if(sellerId == null || sellerId == 0){
            resultBean.setMsg("传入的参数SellerId 为空");
            resultBean.setCode(500);

            return resultBean;
        }

        AmzSellerMws amzSellerMws =  sellerMapperEx.findAmzSellerMwsBySellerId(sellerId);

        resultBean.setData(amzSellerMws);

        return resultBean;
    }

    @Override
    public ResultBean findAmzSellerAccountBySellerId(Integer sellerId) {
        ResultBean resultBean = new ResultBean();

        if(sellerId == null || sellerId == 0){
            resultBean.setMsg("传入的参数SellerId 为空");
            resultBean.setCode(500);

            return resultBean;
        }

        AmzSellerAcount amzSellerAcount = sellerMapperEx.findAmzSellerAcountBySellerId(sellerId);

        resultBean.setData(amzSellerAcount);
        return resultBean;
    }


    @Transactional
    @Override
    public ResultBean saveSellerAccount(AmzSellerAccountVO amzSellerAccountVO) {
        ResultBean resultBean = new ResultBean();

        //校验
        resultBean = checkSellerAccount(amzSellerAccountVO);
        if(resultBean.equals(500)){
            return resultBean;
        }

        int accountId = amzSellerAccountVO.getAccountId();
        //1:先保存
        if(accountId == 0){
            //新增
            sellerAccountMapperEx.addSellerAccount(amzSellerAccountVO);
           // amzSellerAccountVO.setAccountId(amzSellerAccountVO.getAccountId());

            //1.1:判断是否存在对应 module_subscribe
            boolean flag = isExistModuleSubscribeByAccount(amzSellerAccountVO.getAccountId());

            if(!flag){
                //1.2不存在 进行新增
            List<Module> moduleList = moduleMapperEx.findModuleListByModuleType(2);

            if(moduleList == null || moduleList.size() == 0){
                    resultBean.setCode(500);
                    resultBean.setMsg("不存在对应的模块！");
                return resultBean;
            }
            ModuleSubscribe moduleSubscribe = new ModuleSubscribe();

            for(Module module : moduleList){
                moduleSubscribe.setModuleId(module.getModuleId());
                moduleSubscribe.setModuleSettings(module.getDefaultSetting());
                moduleSubscribe.setAccountId(amzSellerAccountVO.getAccountId());
                moduleSubscribe.setSellerId(amzSellerAccountVO.getSellerId());

                moduleSubscribeMapperEx.addModuleSubscribe(moduleSubscribe);

            }

            }else{
                //1.3存在 不进行操作
            }
        }else if(accountId > 0){
            //修改
            sellerAccountMapperEx.updateSellerAccount(amzSellerAccountVO);
        }

        //2:改变状态
        int sellerId = amzSellerAccountVO.getSellerId();

        int num = sellerMapperEx.updateSubAccountStatus(sellerId);
        if(num > 0){
            resultBean.setMsg("保存成功");
        }
        else{
            resultBean.setCode(500);
            resultBean.setMsg("保存失败");
        }

        return resultBean;
    }

    private boolean isExistModuleSubscribeByAccount(int accountId) {
        boolean flag = false;
        Integer num = moduleSubscribeMapperEx.isExistModuleSubscribeByAccount(accountId);
        if(num != null && num > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 校验 SellerAccount 数据是否正确
     * @param amzSellerAccountVO
     * @return
     */
    private ResultBean checkSellerAccount(AmzSellerAccountVO amzSellerAccountVO) {
        ResultBean resultBean = new ResultBean();

        if(amzSellerAccountVO == null){
            resultBean.setCode(500);
            resultBean.setMsg("传入的数据为空保存失败");
            return resultBean;
        }

        if(StringUtils.isEmpty(amzSellerAccountVO.getAccountName())){
            resultBean.setCode(500);
            resultBean.setMsg("账号名为空");
            return resultBean;
        }
        if(StringUtils.isEmpty(amzSellerAccountVO.getAccountPassword())){
            resultBean.setCode(500);
            resultBean.setMsg("密码为空");
            return resultBean;
        }
        if(StringUtils.isEmpty(amzSellerAccountVO.getTwoStepCode())){
            resultBean.setCode(500);
            resultBean.setMsg("二部验证源码为空");
            return resultBean;
        }
        if(StringUtils.isEmpty(amzSellerAccountVO.getRemoteServer())){
            resultBean.setCode(500);
            resultBean.setMsg("服务器为空");
            return resultBean;
        }
        if(amzSellerAccountVO.getRemoteBrowserPort() <= 0){
            resultBean.setCode(500);
            resultBean.setMsg("控制端口为空或非法");
            return resultBean;
        }
        if(amzSellerAccountVO.getRemoteFilePort() <= 0){
            resultBean.setCode(500);
            resultBean.setMsg("传输为空或非法");
            return resultBean;
        }
        return resultBean;
    }

    @Override
    public ResultBean findAmzSellerMwsBySellerId(Integer sellerId) {
        ResultBean resultBean = new ResultBean();

        if(sellerId == null || sellerId == 0){
            resultBean.setCode(500);
            resultBean.setMsg("传入账号Id SellerId为空");
            return resultBean;
        }
        resultBean.setData(amzSellerMwsMapper.findBySellerId(sellerId));
        return resultBean;
    }

    private ResultBean checkSellMwsAuthVO(SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = new ResultBean();

        if(sellerMwsVO == null){
            resultBean.setCode(500);
            resultBean.setMsg("传入的数据为空保存失败");
            return resultBean;
        }

    AmzSeller amzSeller =  sellerMapperEx.findByAmzSellerId(sellerMwsVO.getAmzSellerId());
        if(amzSeller != null ){
            sellerMwsVO.setSellerId(amzSeller.getSellerId());
            sellerMwsVO.setRegionId(amzSeller.getAmazonRegionId());
        }else{
            resultBean.setCode(500);
            resultBean.setMsg("Merchant Token输入错误,没有与之对应的Seller");
            return resultBean;
        }

        if(sellerMwsVO.getSellerId() == 0){
            resultBean.setCode(500);
            resultBean.setMsg("账号为空");
            return resultBean;
        }
        if(sellerMwsVO.getRegionId() == 0){
            resultBean.setCode(500);
            resultBean.setMsg("地区为空");
            return resultBean;
        }

        if(StringUtils.isEmpty(sellerMwsVO.getMwsAppName())){
            resultBean.setCode(500);
            resultBean.setMsg("应用名称为空");
            return resultBean;

        }if(StringUtils.isEmpty(sellerMwsVO.getDeveloperId())){
            resultBean.setCode(500);
            resultBean.setMsg("DeveloperID为空");
            return resultBean;

        }if(StringUtils.isEmpty(sellerMwsVO.getAmzSellerId())){
            resultBean.setCode(500);
            resultBean.setMsg("亚马逊卖家标志 Merchant Token为空");
            return resultBean;

        }if(StringUtils.isEmpty(sellerMwsVO.getMwsAuthToken())){
            resultBean.setCode(500);
            resultBean.setMsg("MWS Auth Token为空");
            return resultBean;
        }

        return resultBean;

    }

    /**
     * 校验 SellerMwsVO
     * @param sellerMwsVO
     * @return
     */
    private ResultBean checkSellMwsVO(SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = new ResultBean();

        if(sellerMwsVO == null){
            resultBean.setCode(500);
            resultBean.setMsg("传入的数据为空保存失败");
            return resultBean;
        }

        AmzSeller amzSeller =  sellerMapperEx.findByAmzSellerId(sellerMwsVO.getAmzSellerId());
        if(amzSeller != null ){
            sellerMwsVO.setSellerId(amzSeller.getSellerId());
            sellerMwsVO.setRegionId(amzSeller.getAmazonRegionId());
        }else{
            resultBean.setCode(500);
            resultBean.setMsg("Merchant Token输入错误,没有与之对应的Seller");
            return resultBean;
        }

        if(sellerMwsVO.getSellerId() == 0){
            resultBean.setCode(500);
            resultBean.setMsg("账号为空");
            return resultBean;
        }
        if(sellerMwsVO.getRegionId() == 0){
            resultBean.setCode(500);
            resultBean.setMsg("地区为空");
            return resultBean;
        }

        if(StringUtils.isEmpty(sellerMwsVO.getMwsAppName())){
            resultBean.setCode(500);
            resultBean.setMsg("应用名称为空");
            return resultBean;

        }if(StringUtils.isEmpty(sellerMwsVO.getAmzSellerId())){
            resultBean.setCode(500);
            resultBean.setMsg("亚马逊卖家标志 Merchant Token为空");
            return resultBean;

        }if(StringUtils.isEmpty(sellerMwsVO.getMwsAuthToken())){
            resultBean.setCode(500);
            resultBean.setMsg("MWS Auth Token为空");
            return resultBean;
        }

        if(StringUtils.isEmpty(sellerMwsVO.getSecretKey())){
            resultBean.setCode(500);
            resultBean.setMsg("Secret Key为空");
            return resultBean;
        }if(StringUtils.isEmpty(sellerMwsVO.getAccessKeyId())){
            resultBean.setCode(500);
            resultBean.setMsg("AWS Access Key ID为空");
            return resultBean;
        }


        return resultBean;
    }
}
