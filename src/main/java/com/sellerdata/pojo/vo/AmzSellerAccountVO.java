package com.sellerdata.pojo.vo;


/**
 * @ClassName AmzSellerAccountVO
 * @Description TODO
 * @Author Lee
 * @Date 19-4-8 上午10:02
 * @Version 1.0
 **/

public class AmzSellerAccountVO {

    private int accountId;

    private int sellerId;

    private String accountName;

    private String accountPassword;

    private String twoStepCode;

    private String remoteServer;

    private int remoteBrowserPort;

    private int remoteFilePort;


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getTwoStepCode() {
        return twoStepCode;
    }

    public void setTwoStepCode(String twoStepCode) {
        this.twoStepCode = twoStepCode;
    }

    public String getRemoteServer() {
        return remoteServer;
    }

    public void setRemoteServer(String remoteServer) {
        this.remoteServer = remoteServer;
    }

    public int getRemoteBrowserPort() {
        return remoteBrowserPort;
    }

    public void setRemoteBrowserPort(int remoteBrowserPort) {
        this.remoteBrowserPort = remoteBrowserPort;
    }

    public int getRemoteFilePort() {
        return remoteFilePort;
    }

    public void setRemoteFilePort(int remoteFilePort) {
        this.remoteFilePort = remoteFilePort;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AmzSellerAccountVO{");
        sb.append("accountId=").append(accountId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", accountPassword='").append(accountPassword).append('\'');
        sb.append(", twoStepCode='").append(twoStepCode).append('\'');
        sb.append(", remoteServer='").append(remoteServer).append('\'');
        sb.append(", remoteBrowserPort=").append(remoteBrowserPort);
        sb.append(", remoteFilePort=").append(remoteFilePort);
        sb.append('}');
        return sb.toString();
    }
}
