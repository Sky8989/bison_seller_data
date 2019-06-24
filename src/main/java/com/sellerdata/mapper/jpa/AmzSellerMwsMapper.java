package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.AmzSellerMws;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmzSellerMwsMapper extends JpaRepository<AmzSellerMws, Integer> {

    AmzSellerMws findBySellerId(int sellerId);


}
