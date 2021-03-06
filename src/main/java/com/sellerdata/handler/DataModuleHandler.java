package com.sellerdata.handler;


import com.sellerdata.service.BrandService;
import com.sellerdata.service.DataModuleService;
import com.sellerdata.service.SellerService;
import com.sellerdata.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Lee
 * @date 2019-6-06
 */
@Api(description = "DataModuleHandler 数据模块控制器", tags = "DataModuleHandler")
@RestController
@RequestMapping("/dataModuleHandler")
public class DataModuleHandler {

    @Autowired
    BrandService brandService;

    @Autowired
    SellerService sellerService;

    @Autowired
    DataModuleService dataModuleService;

    @ApiOperation(value = "获取 数据模块列表")
    @GetMapping(value = "/findDataModuleList/{brandId}")
    public ResultBean findDataModuleList(@PathVariable Integer brandId) {
        ResultBean resultBean = dataModuleService.findDataModuleList(brandId);
        return resultBean;
    }


    @ApiOperation(value = "获取 数据模块列表")
    @GetMapping(value = "/getAmzRegionVOList")
    public ResultBean getAmzRegionVOList() {
        ResultBean resultBean = dataModuleService.getAmzRegionVOList();
        return resultBean;
    }

    @ApiOperation(value = "获取 模块执行状态 列表")
    @GetMapping(value = "/getModuleExcuteStatusList")
    public ResultBean getModuleExcuteStatusList() {
        ResultBean resultBean = dataModuleService.getModuleExcuteStatusList();
        return resultBean;
    }

    @ApiOperation(value = "修改状态 subscribe_status")
    @PutMapping(value = "/updateSubscribeStatus")
    public ResultBean updateSubscribeStatus(@RequestParam("subscribeId") Integer subscribeId,@RequestParam("status") Integer status) {
        System.out.println("subscribeId = " + subscribeId);
        System.out.println("status = " + status);
        ResultBean resultBean = dataModuleService.updateSubscribeStatus(subscribeId,status);
        return resultBean;
    }












}
