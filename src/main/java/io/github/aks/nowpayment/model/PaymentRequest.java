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

    public PaymentRequest(){}
    public PaymentRequest(BigDecimal priceAmount, String priceCurrency, String payCurrency,
                          String orderID, String orderDescription, String ipnCallbackUrl){
        this.priceAmount =priceAmount;
        this.priceCurrency = priceCurrency;
        this.payCurrency = payCurrency;
        this.orderID = orderID;
        this.orderDescription = orderDescription;
        this.ipnCallbackUrl = ipnCallbackUrl;
    }

    public BigDecimal getPriceAmount() {
        return priceAmount;
    }
    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }
    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getPayCurrency() {
        return payCurrency;
    }
    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public String getOrderID() {
        return orderID;
    }

    public String getOrderDescription() {
        return orderDescription;
    }
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getIpnCallbackUrl() {
        return ipnCallbackUrl;
    }
    public void setIpnCallbackUrl(String ipnCallbackUrl) {
        this.ipnCallbackUrl = ipnCallbackUrl;
    }
}
