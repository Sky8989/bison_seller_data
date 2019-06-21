package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandMapper extends JpaRepository<Brand, Integer> {
}
