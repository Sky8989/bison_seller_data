package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryMapper extends JpaRepository<ProductCategory, Integer> {
}
