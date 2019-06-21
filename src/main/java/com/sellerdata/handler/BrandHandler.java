package com.sellerdata.handler;



import com.sellerdata.pojo.Brand;
import com.sellerdata.service.BrandService;
import com.sellerdata.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Lee
 * @date 2019-5-06
 */
@Api(description = "BrandHandler 品牌相关操作", tags = "BrandHandler")
@RestController
@RequestMapping("/brandHandler")
public class BrandHandler {

    @Autowired
    BrandService brandService;

    @ApiOperation(value = "获取所有卖家")
    @GetMapping(value = "/findBrandList")
    public ResultBean findBrandList() {
        ResultBean resultBean = brandService.findBrandList();
        return resultBean;
    }


    @ApiOperation(value = "添加账号")
    @PostMapping(value = "/addBrand")
    public ResultBean addBrand(@RequestBody Brand brand) {

        ResultBean resultBean = brandService.addBrand(brand);

        return resultBean;
    }
}
