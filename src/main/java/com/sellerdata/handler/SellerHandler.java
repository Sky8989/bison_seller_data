package com.sellerdata.handler;


import com.sellerdata.pojo.vo.SellerMwsVO;
import com.sellerdata.service.BrandService;
import com.sellerdata.service.SellerService;
import com.sellerdata.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Lee
 * @date 2019-5-06
 */
@Api(description = "SellerHandler 卖家操作", tags = "SellerHandler")
@RestController
@RequestMapping("/sellerHandler")
public class SellerHandler {

    @Autowired
    BrandService brandService;

    @Autowired
    SellerService sellerService;

    @ApiOperation(value = "获取 seller 列表")
    @GetMapping(value = "/findSellerList/{brandId}")
    public ResultBean findSellerList(@PathVariable Integer brandId) {
        ResultBean resultBean = sellerService.findSellerList(brandId);
        return resultBean;
    }

    @ApiOperation(value = "通过 sellerId 获取 SellerMws")
    @GetMapping(value = "/findSellerMwsBySellerId/{sellerId}")
    public ResultBean findSellerMwsBySellerId(@PathVariable Integer sellerId) {
        ResultBean resultBean = sellerService.findSellerMwsBySellerId(sellerId);
        return resultBean;
    }

    @ApiOperation(value = "通过 sellerId 获取 SellerMws")
    @GetMapping(value = "/findAmzSellerAccountBySellerId/{sellerId}")
    public ResultBean findAmzSellerAccountBySellerId(@PathVariable Integer sellerId) {
        ResultBean resultBean = sellerService.findAmzSellerAccountBySellerId(sellerId);
        return resultBean;
    }

    @ApiOperation(value = "MWS接口设置")
    @PostMapping(value = "/saveSellerMws")
    public ResultBean saveSellerMws(@RequestBody SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = sellerService.saveSellerMwsVO(sellerMwsVO);
        return resultBean;
    }

    @ApiOperation(value = "MWS接口授权")
    @PostMapping(value = "/saveSellerMwsAuth")
    public ResultBean saveSellerMwsAuth(@RequestBody SellerMwsVO sellerMwsVO) {
        ResultBean resultBean = sellerService.saveSellerMwsAuth(sellerMwsVO);
        return resultBean;
    }





}
