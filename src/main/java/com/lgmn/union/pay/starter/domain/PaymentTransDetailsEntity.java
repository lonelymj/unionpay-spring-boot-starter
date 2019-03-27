package com.lgmn.union.pay.starter.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentTransDetailsEntity {

    /**
     * TRANS_DETAIL
     */
    @JsonProperty("TRANS_DETAIL")
    private PaymentTransDetailEntity TRANS_DETAIL;

    public PaymentTransDetailEntity getTRANS_DETAIL() {
        return TRANS_DETAIL;
    }

    public void setTRANS_DETAIL(PaymentTransDetailEntity TRANS_DETAIL) {
        this.TRANS_DETAIL = TRANS_DETAIL;
    }
}
