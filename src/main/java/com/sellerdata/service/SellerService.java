package com.sellerdata.service;


import com.sellerdata.pojo.vo.AmzSellerAccountVO;
import com.sellerdata.pojo.vo.SellerMwsVO;
import com.sellerdata.util.entity.ResultBean;

public interface SellerService {

    ResultBean findSellerList(Integer brandId);

    ResultBean saveSellerMwsVO(SellerMwsVO sellerMwsVO);

    ResultBean saveSellerMwsAuth(SellerMwsVO sellerMwsVO);

    ResultBean findSellerMwsBySellerId(Integer sellerId);

    ResultBean findAmzSellerAccountBySellerId(Integer sellerId);

    ResultBean saveSellerAccount(AmzSellerAccountVO amzSellerAccountVO);

    ResultBean findAmzSellerMwsBySellerId(Integer sellerId);
}
