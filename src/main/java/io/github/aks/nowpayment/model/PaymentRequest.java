package io.github.aks.nowpayment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class PaymentRequest {

    @JsonProperty("price_amount")
    private BigDecimal priceAmount;

    @JsonProperty("price_currency")
    private String priceCurrency;

    @JsonProperty("pay_currency")
    private String payCurrency;

    @JsonProperty("order_id")
    private String orderID;

    @JsonProperty("order_description")
    private String orderDescription;

    @JsonProperty("ipn_callback_url")
    private String ipnCallbackUrl;

    private PaymentRequest(Builder builder) {
        this.priceAmount = builder.priceAmount;
        this.priceCurrency = builder.priceCurrency;
        this.payCurrency = builder.payCurrency;
        this.orderID = builder.orderID;
        this.orderDescription = builder.orderDescription;
        this.ipnCallbackUrl = builder.ipnCallbackUrl;
    }

    // Getters
    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public String getPayCurrency() {
        return payCurrency;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public String getIpnCallbackUrl() {
        return ipnCallbackUrl;
    }

    // Builder
    public static class Builder {
        private BigDecimal priceAmount;
        private String priceCurrency;
        private String payCurrency;
        private String orderID;
        private String orderDescription;
        private String ipnCallbackUrl;

        public Builder priceAmount(BigDecimal priceAmount) {
            this.priceAmount = priceAmount;
            return this;
        }

        public Builder priceCurrency(String priceCurrency) {
            this.priceCurrency = priceCurrency;
            return this;
        }

        public Builder payCurrency(String payCurrency) {
            this.payCurrency = payCurrency;
            return this;
        }

        public Builder orderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder orderDescription(String orderDescription) {
            this.orderDescription = orderDescription;
            return this;
        }

        public Builder ipnCallbackUrl(String ipnCallbackUrl) {
            this.ipnCallbackUrl = ipnCallbackUrl;
            return this;
        }

        public PaymentRequest build() {
            return new PaymentRequest(this);
        }
    }
}

