package com.sellerdata.mapper.jpa;


import com.sellerdata.pojo.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSupplierMapper extends JpaRepository<ProductSupplier, Integer> {

    ProductSupplier findByProductSupplierIdAndStatus(Integer ProductSupplierId, int status);


}
