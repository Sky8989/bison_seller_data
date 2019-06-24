package com.sellerdata.pojo.vo;


import java.sql.Timestamp;

/**
 * @ClassName AmzSeller
 * @Description TODO
 * @Author peter
 * @Date 19-4-8 上午10:02
 * @Version 1.0
 **/

public class DataModuleVO {


    private int moduleId;
    /**
     * 模块
     */
    private String moduleName;


    /**
     *module_subscribe 的状态
     */
    private int subscribeStatus;


    /**
     *账号和执行表的状态和关系表 id
     */
    private int subscribeId;



    private Timestamp lastExecuteTime;

    /**
     * 区域id
     */
    private int amzRegionId;

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

    public int getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(int subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Timestamp getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Timestamp lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public int getAmzRegionId() {
        return amzRegionId;
    }

    public void setAmzRegionId(int amzRegionId) {
        this.amzRegionId = amzRegionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataModuleVO{");
        sb.append("moduleId=").append(moduleId);
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", subscribeStatus=").append(subscribeStatus);
        sb.append(", subscribeId=").append(subscribeId);
        sb.append(", lastExecuteTime=").append(lastExecuteTime);
        sb.append(", amzRegionId=").append(amzRegionId);
        sb.append('}');
        return sb.toString();
    }
}
