package com.sellerdata.service;


import com.sellerdata.util.entity.ResultBean;

public interface DataModuleService {


    ResultBean findDataModuleList(Integer brandId);

    ResultBean getAmzRegionVOList();

    ResultBean getModuleExcuteStatusList();

    ResultBean updateSubscribeStatus(Integer subscribeId, Integer status);
}
