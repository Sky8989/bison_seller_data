package com.sellerdata.mapper.mybatis;


import com.sellerdata.pojo.AmzSellerAcount;
import com.sellerdata.pojo.AmzSellerMws;
import com.sellerdata.pojo.vo.SellerMwsVO;
import com.sellerdata.pojo.vo.SellerVO;

import java.util.List;

public interface SellerMapperEx {


    List<SellerVO> findSellerList(Integer brandId);

    void addSellerMws(SellerMwsVO sellerMwsVO);

    int updateSellerMws(SellerMwsVO sellerMwsVO);

    int updateMwsStatus(int sellerId);

    int updateEasybisonMwsStatus(int sellerId);



    AmzSellerMws findAmzSellerMwsBySellerId(Integer sellerId);

    AmzSellerAcount findAmzSellerAcountBySellerId(Integer sellerId);
}
