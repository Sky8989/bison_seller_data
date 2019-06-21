package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.UserCountryProductRel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCountryProductRelMapper extends JpaRepository<UserCountryProductRel,Integer> {

    UserCountryProductRel findByUserIdAndCountryIdAndProductId(Integer userId, Integer countryId, Integer productId);
}
