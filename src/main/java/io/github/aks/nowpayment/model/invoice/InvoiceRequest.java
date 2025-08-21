package io.github.aks.nowpayment.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceRequest {

    @JsonProperty("price_amount")
    private String priceAmount;
    @JsonProperty("price_currency")
    private String priceCurrency;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("order_description")
    private String orderDescription;
    @JsonProperty("ipn_callback_url")
    private String ipnCallbackUrl;
    @JsonProperty("success_url")
    private String successUrl;
    @JsonProperty("cancel_url")
    private String cancelUrl;

    private InvoiceRequest(Builder builder){
        this.priceAmount = builder.priceAmount;
        this.priceCurrency = builder.priceCurrency;
        this.orderId = builder.orderId;
        this.orderDescription = builder.orderDescription;
        this.ipnCallbackUrl = builder.ipnCallbackUrl;
        this.successUrl = builder.successUrl;
        this.cancelUrl = builder.cancelUrl;
    }

    public static class Builder{
        private String priceAmount;
        private String priceCurrency;
        private String orderId;
        private String orderDescription;
        private String ipnCallbackUrl;
        private String successUrl;
        private String cancelUrl;

        public Builder priceAmount(String priceAmount){
            this.priceAmount = priceAmount;
            return this;
        }
        public Builder priceCurrency(String priceCurrency){
            this.priceCurrency = priceCurrency;
            return this;
        }
        public Builder orderId(String orderId){
            this.orderId = orderId;
            return this;
        }
        public Builder orderDescription(String orderDescription){
            this.orderDescription = orderDescription;
            return this;
        }
        public Builder ipnCallbackUrl(String ipnCallbackUrl){
            this.ipnCallbackUrl = ipnCallbackUrl;
            return this;
        }
        public Builder successUrl(String successUrl){
            this.successUrl = successUrl;
            return this;
        }
        public Builder cancelUrl(String cancelUrl){
            this.cancelUrl = cancelUrl;
            return this;
        }

        public InvoiceRequest build(){
            return new InvoiceRequest(this);
        }
    }

}
