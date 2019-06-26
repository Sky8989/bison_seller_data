package com.sellerdata.mapper.mybatis;


import com.sellerdata.pojo.ModuleSubscribe;
import org.apache.ibatis.annotations.Param;

public interface ModuleSubscribeMapperEx {


    int updateSubscribeStatus(@Param("subscribeId") Integer subscribeId, @Param("subscribeStatus")Integer status);

    int updateLastExecuteStatusId(@Param("subscribeId")Integer subscribeId, @Param("lastExecuteStatusId")int excuteStatusId);

    Integer isExistModuleSubscribeByMwsId(int mwsId);

    void addModuleSubscribe(ModuleSubscribe moduleSubscribe);

    Integer isExistModuleSubscribeByAccount(int accountId);
}
