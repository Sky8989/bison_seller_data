package com.sellerdata.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName AmzSellerAcount
 * @Description TODO
 * @Author Lee
 * @Date 19-4-8 下午4:03
 * @Version 1.0
 **/
@Entity
@Table(name = "amz_seller_account", schema = "bison")
public class AmzSellerAcount {

    private int accountId;

    private int sellerId;

    private String accountName;

    private String accountPassword;

    private String remoteServer;

    private String twoStepCode;

    private int isAmzAdvAuthorize;

    private int remoteFilePort;

    private int remoteBrowserPort;

    private int amzSellercentralEntryId;

    private Timestamp utime;
    private Timestamp ctime;

    @Id
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "seller_id", nullable = false)
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "account_password")
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Basic
    @Column(name = "remote_server")
    public String getRemoteServer() {
        return remoteServer;
    }

    public void setRemoteServer(String remoteServer) {
        this.remoteServer = remoteServer;
    }

    @Basic
    @Column(name = "two_step_code")
    public String getTwoStepCode() {
        return twoStepCode;
    }

    public void setTwoStepCode(String twoStepCode) {
        this.twoStepCode = twoStepCode;
    }

    @Basic
    @Column(name = "is_amz_adv_authorize")
    public int getIsAmzAdvAuthorize() {
        return isAmzAdvAuthorize;
    }

    public void setIsAmzAdvAuthorize(int isAmzAdvAuthorize) {
        this.isAmzAdvAuthorize = isAmzAdvAuthorize;
    }

    @Basic
    @Column(name = "remote_file_port")
    public int getRemoteFilePort() {
        return remoteFilePort;
    }

    public void setRemoteFilePort(int remoteFilePort) {
        this.remoteFilePort = remoteFilePort;
    }

    @Basic
    @Column(name = "remote_browser_port")
    public int getRemoteBrowserPort() {
        return remoteBrowserPort;
    }

    public void setRemoteBrowserPort(int remoteBrowserPort) {
        this.remoteBrowserPort = remoteBrowserPort;
    }

    @Basic
    @Column(name = "amz_sellercentral_entry_id")
    public int getAmzSellercentralEntryId() {
        return amzSellercentralEntryId;
    }

    public void setAmzSellercentralEntryId(int amzSellercentralEntryId) {
        this.amzSellercentralEntryId = amzSellercentralEntryId;
    }

    @Basic
    @Column(name = "utime", nullable = false)
    public Timestamp getUtime() {
        return utime;
    }

    public void setUtime(Timestamp utime) {
        this.utime = utime;
    }

    @Basic
    @Column(name = "ctime", nullable = false)
    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AmzSellerAcount{");
        sb.append("accountId=").append(accountId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountPassword='").append(accountPassword).append('\'');
        sb.append(", remoteServer='").append(remoteServer).append('\'');
        sb.append(", twoStepCode='").append(twoStepCode).append('\'');
        sb.append(", isAmzAdvAuthorize=").append(isAmzAdvAuthorize);
        sb.append(", remoteFilePort=").append(remoteFilePort);
        sb.append(", remoteBrowserPort=").append(remoteBrowserPort);
        sb.append(", amzSellercentralEntryId=").append(amzSellercentralEntryId);
        sb.append('}');
        return sb.toString();
    }
}
