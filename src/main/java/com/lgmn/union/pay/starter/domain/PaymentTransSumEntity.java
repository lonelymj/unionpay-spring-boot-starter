package com.lgmn.union.pay.starter.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentTransSumEntity {

    /**
     * 非空
     * 业务代码
     */
    @JsonProperty("BUSINESS_CODE")
    private String BUSINESS_CODE;

    /**
     * 非空
     * 商户代码
     * 银联网络商户ID
     */
    @JsonProperty("MERCHANT_ID")
    private String MERCHANT_ID;

    /**
     * 非空
     * 提交时间
     * YYYYMMDDHHMMSS
     */
    @JsonProperty("SUBMIT_TIME")
    private String SUBMIT_TIME;

    /**
     * 非空
     * TOTAL_ITEM
     * 固定为1
     */
    @JsonProperty("TOTAL_ITEM")
    private String TOTAL_ITEM;

    /**
     * 非空
     * TOTAL_SUM
     * 整数，单位分
     */
    @JsonProperty("TOTAL_SUM")
    private Integer TOTAL_SUM;

    public String getBUSINESS_CODE() {
        return BUSINESS_CODE;
    }

    public void setBUSINESS_CODE(String BUSINESS_CODE) {
        this.BUSINESS_CODE = BUSINESS_CODE;
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getSUBMIT_TIME() {
        return SUBMIT_TIME;
    }

    public void setSUBMIT_TIME(String SUBMIT_TIME) {
        this.SUBMIT_TIME = SUBMIT_TIME;
    }

    public String getTOTAL_ITEM() {
        return TOTAL_ITEM;
    }

    public void setTOTAL_ITEM(String TOTAL_ITEM) {
        this.TOTAL_ITEM = TOTAL_ITEM;
    }

    public Integer getTOTAL_SUM() {
        return TOTAL_SUM;
    }

    public void setTOTAL_SUM(Integer TOTAL_SUM) {
        this.TOTAL_SUM = TOTAL_SUM;
    }
}
