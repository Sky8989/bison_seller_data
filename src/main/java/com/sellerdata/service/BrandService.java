package com.sellerdata.service;


import com.sellerdata.pojo.Brand;
import com.sellerdata.util.entity.ResultBean;

public interface BrandService {


    /**
     * 查询所有卖家
     * @return
     */
    ResultBean findBrandList();


    /**
     * 添加账号
     * @param brand
     * @return
     */
    ResultBean addBrand(Brand brand);
}
