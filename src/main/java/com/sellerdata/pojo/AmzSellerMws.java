package com.sellerdata.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName AmzSeller
 * @Description TODO
 * @Author Lee
 * @Date 19-6-21 上午10:02
 * @Version 1.0
 **/
@Entity
@Table(name = "amz_seller_mws", schema = "bison", catalog = "")
public class AmzSellerMws {
    private int mwsId;
    private int sellerId;
    private int regionId;


    private String mwsAppName;
    private String amzSellerId;

    private String mwsAuthToken;
    private String developerId;
    private String secretKey;
    private String accessKeyId;
    private int authType;


    private Timestamp utime;
    private Timestamp ctime;


    @Id
    @Column(name = "mws_id", nullable = false)
    public int getMwsId() {
        return mwsId;
    }

    public void setMwsId(int mwsId) {
        this.mwsId = mwsId;
    }

    @Column(name = "seller_id", nullable = false)
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "amz_seller_id")
    public String getAmzSellerId() {
        return amzSellerId;
    }


    public void setAmzSellerId(String amzSellerId) {
        this.amzSellerId = amzSellerId;
    }


    @Basic
    @Column(name = "access_key_id")
    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Basic
    @Column(name = "region_id")
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "mws_app_name")
    public String getMwsAppName() {
        return mwsAppName;
    }

    public void setMwsAppName(String mwsAppName) {
        this.mwsAppName = mwsAppName;
    }

    @Basic
    @Column(name = "mws_auth_token")
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public void setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
    }

    @Basic
    @Column(name = "developer_id")
    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    @Basic
    @Column(name = "secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Basic
    @Column(name = "auth_type" )
    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
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
        final StringBuilder sb = new StringBuilder("AmzSellerMws{");
        sb.append("mwsId=").append(mwsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", amzSellerId=").append(amzSellerId);
        sb.append(", regionId=").append(regionId);
        sb.append(", mwsAppName='").append(mwsAppName).append('\'');
        sb.append(", mwsAuthToken='").append(mwsAuthToken).append('\'');
        sb.append(", developerId='").append(developerId).append('\'');
        sb.append(", secretKey='").append(secretKey).append('\'');
        sb.append(", authType=").append(authType);
        sb.append(", utime=").append(utime);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }
}
