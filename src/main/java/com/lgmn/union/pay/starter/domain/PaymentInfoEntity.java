package com.lgmn.union.pay.starter.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 代付
 */
public class PaymentInfoEntity {

    /**
     * 非空
     * 交易代码
     * 100005
     */
    @JsonProperty("TRX_CODE")
    private String TRX_CODE;

    /**
     * 非空
     * 版本
     * 05
     */
    @JsonProperty("VERSION")
    private String VERSION;

    /**
     * 可空
     * 数据格式
     * xml格式
     */
    @JsonProperty("DATA_TYPE")
    private String DATA_TYPE;

    /**
     * 可空
     * 处理级别
     * 0-9
     * 0实时处理
     * 默认5
     */
    @JsonProperty("LEVEL")
    private String LEVEL;

    /**
     * 非空
     * 用户名
     */
    @JsonProperty("USER_NAME")
    private String USER_NAME;

    /**
     * 非空
     * 用户密码
     */
    @JsonProperty("USER_PASS")
    private String USER_PASS;

    /**
     * 非空
     * 交易流水号
     */
    @JsonProperty("REQ_SN")
    private String REQ_SN;

    /**
     * 非空
     * 签名信息
     */
    @JsonProperty("SIGNED_MSG")
    private String SIGNED_MSG;

    public String getTRX_CODE() {
        return TRX_CODE;
    }

    public void setTRX_CODE(String TRX_CODE) {
        this.TRX_CODE = TRX_CODE;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE;
    }

    public String getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(String LEVEL) {
        this.LEVEL = LEVEL;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASS() {
        return USER_PASS;
    }

    public void setUSER_PASS(String USER_PASS) {
        this.USER_PASS = USER_PASS;
    }

    public String getREQ_SN() {
        return REQ_SN;
    }

    public void setREQ_SN(String REQ_SN) {
        this.REQ_SN = REQ_SN;
    }

    public String getSIGNED_MSG() {
        return SIGNED_MSG;
    }

    public void setSIGNED_MSG(String SIGNED_MSG) {
        this.SIGNED_MSG = SIGNED_MSG;
    }
}
