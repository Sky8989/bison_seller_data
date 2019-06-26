package com.sellerdata.pojo.vo;


/**
 * @ClassName AmzRegionVO
 * @Description TODO
 * @Author Lee
 * @Date 19-6-21 上午10:02
 * @Version 1.0
 **/

public class AmzRegionVO {


    private int amzRegionId;

    private String amzRegionCode;

    public int getAmzRegionId() {
        return amzRegionId;
    }

    public void setAmzRegionId(int amzRegionId) {
        this.amzRegionId = amzRegionId;
    }

    public String getAmzRegionCode() {
        return amzRegionCode;
    }

    public void setAmzRegionCode(String amzRegionCode) {
        this.amzRegionCode = amzRegionCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AmzRegionVO{");
        sb.append("amzRegionId=").append(amzRegionId);
        sb.append(", amzRegionCode='").append(amzRegionCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
