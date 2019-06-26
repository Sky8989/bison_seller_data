package com.sellerdata.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName ModuleSubscribe
 * @Description TODO
 * @Author Lee
 * @Date 19-6-28 下午4:03
 * @Version 1.0
 **/
@Entity
@Table(name = "module_subscribe", schema = "bison")
public class ModuleSubscribe {

    private int subscribeId;
    private int moduleId;
    private int sellerId;
    private int accountId;
    private int mwsId;
    private int subscribeStatus;


    private String moduleServerUrl;

    private String moduleSettings;

    private String cornExpressoin;

    private int lastExecuteStatusId;

    private Timestamp  lastExecuteTime;

    private Timestamp lastFinishTime;

    private Timestamp utime;

    private Timestamp ctime;

    public ModuleSubscribe(){

    }

    @Id
    @Column(name = "subscribe_id", nullable = false)
    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    @Basic
    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "seller_id")
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "mws_id")
    public int getMwsId() {
        return mwsId;
    }

    public void setMwsId(int mwsId) {
        this.mwsId = mwsId;
    }

    @Basic
    @Column(name = "subscribe_status")
    public int getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(int subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    @Basic
    @Column(name = "module_server_url")
    public String getModuleServerUrl() {
        return moduleServerUrl;
    }

    public void setModuleServerUrl(String moduleServerUrl) {
        this.moduleServerUrl = moduleServerUrl;
    }

    @Basic
    @Column(name = "module_settings")
    public String getModuleSettings() {
        return moduleSettings;
    }

    public void setModuleSettings(String moduleSettings) {
        this.moduleSettings = moduleSettings;
    }

    @Basic
    @Column(name = "corn_expressoin")
    public String getCornExpressoin() {
        return cornExpressoin;
    }

    public void setCornExpressoin(String cornExpressoin) {
        this.cornExpressoin = cornExpressoin;
    }

    @Basic
    @Column(name = "last_execute_status_id")
    public int getLastExecuteStatusId() {
        return lastExecuteStatusId;
    }

    public void setLastExecuteStatusId(int lastExecuteStatusId) {
        this.lastExecuteStatusId = lastExecuteStatusId;
    }

    @Basic
    @Column(name = "last_execute_time")
    public Timestamp getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Timestamp lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    @Basic
    @Column(name = "last_finish_time")
    public Timestamp getLastFinishTime() {
        return lastFinishTime;
    }

    public void setLastFinishTime(Timestamp lastFinishTime) {
        this.lastFinishTime = lastFinishTime;
    }


    @Basic
    @Column(name = "utime")
    public Timestamp getUtime() {
        return utime;
    }

    public void setUtime(Timestamp utime) {
        this.utime = utime;
    }

    @Basic
    @Column(name = "ctime")
    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModuleSubscribe{");
        sb.append("subscribeId=").append(subscribeId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", accountId=").append(accountId);
        sb.append(", mwsId=").append(mwsId);
        sb.append(", subscribeStatus=").append(subscribeStatus);
        sb.append(", moduleServerUrl='").append(moduleServerUrl).append('\'');
        sb.append(", moduleSettings='").append(moduleSettings).append('\'');
        sb.append(", cornExpressoin='").append(cornExpressoin).append('\'');
        sb.append(", lastExecuteStatusId=").append(lastExecuteStatusId);
        sb.append(", lastExecuteTime=").append(lastExecuteTime);
        sb.append(", lastFinishTime=").append(lastFinishTime);
        sb.append(", utime=").append(utime);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }
}
