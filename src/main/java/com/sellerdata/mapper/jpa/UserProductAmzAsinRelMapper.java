package com.sellerdata.mapper.jpa;


import com.sellerdata.pojo.UserProductAmzAsinRel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProductAmzAsinRelMapper extends JpaRepository<UserProductAmzAsinRel,Integer> {

    UserProductAmzAsinRel findByUserIdAndProductIdAndCountryIdAndAsinId(Integer userId, Integer productId, Integer countryId, Integer asinId);


}