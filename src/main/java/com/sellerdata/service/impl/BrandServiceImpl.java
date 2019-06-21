package com.sellerdata.service.impl;

import com.sellerdata.mapper.jpa.BrandMapper;
import com.sellerdata.mapper.jpa.UserMapper;

import com.sellerdata.pojo.Brand;
import com.sellerdata.pojo.Product;
import com.sellerdata.service.BrandService;
import com.sellerdata.util.entity.ResultBean;
import com.sellerdata.mapper.mybatis.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BrandMapper brandMapper;


    @Override
    public ResultBean findBrandList() {
        ResultBean resultBean = new ResultBean();

        List<Brand> brandList = brandMapper.findAll();
        resultBean.setData(brandList);

        return resultBean;
    }

    @Override
    public ResultBean addBrand(Brand brand) {
        ResultBean resultBean = new ResultBean();
        if(brand == null || StringUtils.isEmpty(brand.getBrandName())){
            resultBean.setCode(500);
            resultBean.setMsg("传入参数为空,新增失败!");
            return resultBean;
        }

        brand = brandMapper.save(brand);

        if(brand != null && brand.getBrandId() > 0){
            resultBean.setCode(200);
            resultBean.setMsg("新增成功!");
        }

        return resultBean;
    }


}
