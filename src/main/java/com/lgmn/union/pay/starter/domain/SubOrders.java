package com.lgmn.union.pay.starter.domain;

/**
 * 分账信息(全非必传属性)
 *
 * 在传分账标记的情况下，若传子商户号，子商户分账金额必传，即ubOrders每个元素的mid和totalAmount非空 且 mid不超过20个
 *
 */
public class SubOrders {

    /**
     * 子商户号
     */
    private String mid;

    /**
     * 子商户分账金额
     */
    private Integer totalAmount;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
