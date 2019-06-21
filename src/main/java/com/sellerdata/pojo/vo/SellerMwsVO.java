package com.sellerdata.pojo.vo;


/**
 * @ClassName SellerMwsVO
 * @Description TODO
 * @Author Lee
 * @Date 19-6-21 上午10:02
 * @Version 1.0
 **/

public class SellerMwsVO {


    private int mwsId;

    private int  sellerId;
    private int  regionId;
    /**
     * 应用名称
     */
    private String mwsAppName;

    /**
     *
     */
    private String developerId;

    /**
     *亚马逊分配给seller的ID
     */
    private String amzSellerId;

    /**
     *亚马逊分配的MWS Authorisation Token
     */
    private String mwsAuthToken;

    /**
     * 亚马逊分配的Secret Key
     */
    private String secretKey;

    /**
     * 亚马逊分配的AWS Access Key ID
     */
    private String accessKeyId;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getMwsId() {
        return mwsId;
    }

    public void setMwsId(int mwsId) {
        this.mwsId = mwsId;
    }

    public String getMwsAppName() {
        return mwsAppName;
    }

    public void setMwsAppName(String mwsAppName) {
        this.mwsAppName = mwsAppName;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getAmzSellerId() {
        return amzSellerId;
    }

    public void setAmzSellerId(String amzSellerId) {
        this.amzSellerId = amzSellerId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public void setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SellerMwsVO{");
        sb.append("mwsId=").append(mwsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", regionId=").append(regionId);
        sb.append(", mwsAppName='").append(mwsAppName).append('\'');
        sb.append(", developerId='").append(developerId).append('\'');
        sb.append(", amzSellerId='").append(amzSellerId).append('\'');
        sb.append(", mwsAuthToken='").append(mwsAuthToken).append('\'');
        sb.append(", secretKey='").append(secretKey).append('\'');
        sb.append(", accessKeyId='").append(accessKeyId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
