package com.sellerdata.pojo.vo;


import java.sql.Timestamp;

/**
 * @ClassName ModuleSubscribeVO
 * @Description TODO
 * @Author Lee
 * @Date 19-4-28 上午10:02
 * @Version 1.0
 **/

public class ModuleSubscribeVO {


    /**
     *账号和执行表的状态和关系表 id
     */
    private int subscribeId;

    /**
     *module_subscribe 的状态
     */
    private int subscribeStatus;

    /**
     * 模块执行状态
     */
    private int lastExecuteStatusId;


    private Timestamp lastExecuteTime;

    /**
     * 区域id
     */
    private int amzRegionId;

    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    public int getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(int subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public int getLastExecuteStatusId() {
        return lastExecuteStatusId;
    }

    public void setLastExecuteStatusId(int lastExecuteStatusId) {
        this.lastExecuteStatusId = lastExecuteStatusId;
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
        final StringBuilder sb = new StringBuilder("ModuleSubscribeVO{");
        sb.append("subscribeId=").append(subscribeId);
        sb.append(", subscribeStatus=").append(subscribeStatus);
        sb.append(", lastExecuteStatusId=").append(lastExecuteStatusId);
        sb.append(", lastExecuteTime=").append(lastExecuteTime);
        sb.append(", amzRegionId=").append(amzRegionId);
        sb.append('}');
        return sb.toString();
    }
}
