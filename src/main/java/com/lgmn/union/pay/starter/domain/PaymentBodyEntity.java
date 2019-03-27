package com.lgmn.union.pay.starter.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentBodyEntity {

    /**
     * TRANS_SUM
     */
    @JsonProperty("TRANS_SUM")
    private PaymentTransSumEntity TRANS_SUM;

    /**
     * TRANS_DETAILS
     */
    @JsonProperty("TRANS_DETAILS")
    private PaymentTransDetailsEntity TRANS_DETAILS;

    public PaymentTransSumEntity getTRANS_SUM() {
        return TRANS_SUM;
    }

    public void setTRANS_SUM(PaymentTransSumEntity TRANS_SUM) {
        this.TRANS_SUM = TRANS_SUM;
    }

    public PaymentTransDetailsEntity getTRANS_DETAILS() {
        return TRANS_DETAILS;
    }

    public void setTRANS_DETAILS(PaymentTransDetailsEntity TRANS_DETAILS) {
        this.TRANS_DETAILS = TRANS_DETAILS;
    }
}
