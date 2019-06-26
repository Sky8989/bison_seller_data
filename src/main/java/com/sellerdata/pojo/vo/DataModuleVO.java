package com.sellerdata.pojo.vo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DataModuleVO
 * @Description TODO
 * @Author Lee
 * @Date 19-6-28 上午10:02
 * @Version 1.0
 **/

public class DataModuleVO {


    private int moduleId;
    /**
     * 模块
     */
    private String moduleName;


    /**
     *账号和执行表的状态和关系表 id 列表
     */
    private String subscribeIdStr;

    /**
     *
     * ModuleSubscribeVO
     */
    private List<ModuleSubscribeVO> moduleSubscribeVOList;


    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubscribeIdStr() {
        return subscribeIdStr;
    }

    public void setSubscribeIdStr(String subscribeIdStr) {
        this.subscribeIdStr = subscribeIdStr;
    }

    public List<ModuleSubscribeVO> getModuleSubscribeVOList() {
        return moduleSubscribeVOList;
    }

    public void setModuleSubscribeVOList(List<ModuleSubscribeVO> moduleSubscribeVOList) {
        this.moduleSubscribeVOList = moduleSubscribeVOList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataModuleVO{");
        sb.append("moduleId=").append(moduleId);
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", subscribeIdStr='").append(subscribeIdStr).append('\'');
        sb.append(", moduleSubscribeVOList=").append(moduleSubscribeVOList);
        sb.append('}');
        return sb.toString();
    }
}
