package com.sellerdata.service.impl;

import com.sellerdata.mapper.jpa.AmzSellerMapper;
import com.sellerdata.mapper.jpa.AmzSellerMwsMapper;
import com.sellerdata.mapper.jpa.BrandMapper;
import com.sellerdata.mapper.jpa.UserMapper;
import com.sellerdata.mapper.mybatis.SellerMapperEx;
import com.sellerdata.pojo.AmzSellerAcount;
import com.sellerdata.pojo.AmzSellerMws;
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

        int mwsId = sellerMwsVO.getMwsId();
        //1:先保存
        if(mwsId == 0){
            //新增
            sellerMapperEx.addSellerMws(sellerMwsVO);
             sellerMwsVO.getMwsId();

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
            sellerMwsVO.getMwsId();

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

        AmzSellerMws amzSellerMws =  sellerMapperEx.findAmzSellerMwsBySellerId(sellerId);

        resultBean.setData(amzSellerMws);

        return resultBean;
    }

    @Override
    public ResultBean findAmzSellerAccountBySellerId(Integer sellerId) {
        ResultBean resultBean = new ResultBean();

        AmzSellerAcount amzSellerAcount = sellerMapperEx.findAmzSellerAcountBySellerId(sellerId);

        resultBean.setData(amzSellerAcount);
        return resultBean;
    }

    private ResultBean checkSellMwsAuthVO(SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = new ResultBean();

        if(sellerMwsVO == null){
            resultBean.setCode(500);
            resultBean.setMsg("传入的数据为空保存失败");
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
