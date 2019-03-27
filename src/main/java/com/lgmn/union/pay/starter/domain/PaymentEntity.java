package com.lgmn.union.pay.starter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class PaymentEntity {

    @JsonProperty("INFO")
    private PaymentInfoEntity INFO;

    @JsonProperty("BODY")
    private PaymentBodyEntity BODY;

    public PaymentInfoEntity getINFO() {
        return INFO;
    }

    public void setINFO(PaymentInfoEntity INFO) {
        this.INFO = INFO;
    }

    public PaymentBodyEntity getBODY() {
        return BODY;
    }

    public void setBODY(PaymentBodyEntity BODY) {
        this.BODY = BODY;
    }
}
