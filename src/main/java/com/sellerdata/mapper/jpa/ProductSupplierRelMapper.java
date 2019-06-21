package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.ProductSupplierRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSupplierRelMapper extends JpaRepository<ProductSupplierRel, Integer> {

    List<ProductSupplierRel> findByProductId(Integer productId);
}
