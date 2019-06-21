package com.sellerdata.pojo.vo;


/**
 * @ClassName AmzSeller
 * @Description TODO
 * @Author peter
 * @Date 19-4-8 上午10:02
 * @Version 1.0
 **/

public class SellerVO {


    private int sellerId;
    private int brandId;
    private int regionId;


    private String amzRegionCode;

    /**
     * 数据模块状态 0未设置 1已设置
     */
    private int mwsStatus;
    /**
     * 授权状态 0未授权 1已授权
     */
    private int easybisonMwsStatus;
    /**
     * 子账号设置状态 0未设置 1已设置
     */
    private int subAccountStatus;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getAmzRegionCode() {
        return amzRegionCode;
    }

    public void setAmzRegionCode(String amzRegionCode) {
        this.amzRegionCode = amzRegionCode;
    }

    public int getMwsStatus() {
        return mwsStatus;
    }

    public void setMwsStatus(int mwsStatus) {
        this.mwsStatus = mwsStatus;
    }

    public int getEasybisonMwsStatus() {
        return easybisonMwsStatus;
    }

    public void setEasybisonMwsStatus(int easybisonMwsStatus) {
        this.easybisonMwsStatus = easybisonMwsStatus;
    }

    public int getSubAccountStatus() {
        return subAccountStatus;
    }

    public void setSubAccountStatus(int subAccountStatus) {
        this.subAccountStatus = subAccountStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SellerVO{");
        sb.append("sellerId=").append(sellerId);
        sb.append(", brandId=").append(brandId);
        sb.append(", regionId=").append(regionId);
        sb.append(", amzRegionCode='").append(amzRegionCode).append('\'');
        sb.append(", mwsStatus=").append(mwsStatus);
        sb.append(", easybisonMwsStatus=").append(easybisonMwsStatus);
        sb.append(", subAccountStatus=").append(subAccountStatus);
        sb.append('}');
        return sb.toString();
    }
}
