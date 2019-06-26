package com.sellerdata.mapper.mybatis;


import com.sellerdata.pojo.AmzSeller;
import com.sellerdata.pojo.AmzSellerAcount;
import com.sellerdata.pojo.AmzSellerMws;
import com.sellerdata.pojo.vo.DataModuleVO;
import com.sellerdata.pojo.vo.ModuleSubscribeVO;
import com.sellerdata.pojo.vo.SellerMwsVO;
import com.sellerdata.pojo.vo.SellerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerMapperEx {

    List<SellerVO> findSellerList(Integer brandId);

    void addSellerMws(SellerMwsVO sellerMwsVO);

    int updateSellerMws(SellerMwsVO sellerMwsVO);

    int updateMwsStatus(int sellerId);

    int updateEasybisonMwsStatus(int sellerId);



    AmzSellerMws findAmzSellerMwsBySellerId(Integer sellerId);

    AmzSellerAcount findAmzSellerAcountBySellerId(Integer sellerId);

    int updateSubAccountStatus(int sellerId);

    List<DataModuleVO> findDataModuleList(Integer brandId);

    List<ModuleSubscribeVO> findModuleSubscribeVOList(@Param("subscribeIdList") List<String> subscribeIdList);

    AmzSeller findByAmzSellerId(String amzSellerId);
}
