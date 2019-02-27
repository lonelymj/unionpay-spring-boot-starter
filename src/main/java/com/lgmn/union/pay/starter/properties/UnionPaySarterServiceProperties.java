package com.lgmn.union.pay.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("unionpay.service")
public class UnionPaySarterServiceProperties {

    /**
     * 商户号
     */
    private String mid;

    /**
     * 终端号
     */
    private String tid;

    /**
     * 机构商户号
     */
    private String instMid;

    /**
     * 是否测试环境
     */
    private Boolean isTest;

    /**
     * 订单号前缀，需要银行分配的前4位
     */
    private String orderNoPrefix;
    /**
     * 消息来源
     */
    private String msgSrc;

    /**
     * 消息类型
     */
    private String msgType;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getInstMid() {
        return instMid;
    }

    public void setInstMid(String instMid) {
        this.instMid = instMid;
    }

    public Boolean getIsTest() {
        return isTest;
    }

    public void setIsTest(Boolean isTest) {
        this.isTest = isTest;
    }

    public String getOrderNoPrefix() {
        return orderNoPrefix;
    }

    public void setOrderNoPrefix(String orderNoPrefix) {
        this.orderNoPrefix = orderNoPrefix;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
