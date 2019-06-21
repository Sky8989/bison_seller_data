package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Integer> {

    User findByUserId(int userId);


}
