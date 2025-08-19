package io.github.aks.nowpayment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class InvoiceResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("order_id")
    private String order_id;

    @JsonProperty("order_description")
    private String order_description;

    @JsonProperty("price_amount")
    private String price_amount;

    @JsonProperty("price_currency")
    private String price_currency;

    @JsonProperty("pay_currency")
    private String pay_currency;

    @JsonProperty("ipn_callback_url")
    private String ipn_callback_url;

    @JsonProperty("invoice_url")
    private String invoice_url;

    @JsonProperty("success_url")
    private String success_url;

    @JsonProperty("cancel_url")
    private String cancel_url;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("token_id")
    private String token_id;

    @JsonProperty("customer_email")
    private String customer_email;

    @JsonProperty("partially_paid_url")
    private String partially_paid_url;

    @JsonProperty("payout_currency")
    private String payout_currency;

    @JsonProperty("is_fixed_rate")
    private Boolean is_fixed_rate;

    @JsonProperty("is_fee_paid_by_user")
    private Boolean is_fee_paid_by_user;

    @JsonProperty("source")
    private String source;

    @JsonProperty("collect_user_data")
    private String collect_user_data;

    private InvoiceResponse(){

    }
    private InvoiceResponse(Builder builder){
        this.id = builder.id;
        this.order_id = builder.order_id;
        this.order_description = builder.order_description;
        this.price_amount = builder.price_amount;
        this.price_currency = builder.price_currency;
        this.pay_currency = builder.pay_currency;
        this.ipn_callback_url = builder.ipn_callback_url;
        this.invoice_url = builder.invoice_url;
        this.success_url = builder.success_url;
        this.cancel_url = builder.cancel_url;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
        this.token_id = builder.token_id;
        this.customer_email = builder.customer_email;
        this.partially_paid_url = builder.partially_paid_url;
        this.payout_currency = builder.payout_currency;
        this.is_fixed_rate = builder.is_fixed_rate;
        this.is_fee_paid_by_user = builder.is_fee_paid_by_user;
        this.source = builder.source;
        this.collect_user_data = builder.collect_user_data;
    }

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_description() {
        return order_description;
    }

    public String getPrice_amount() {
        return price_amount;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getPay_currency() {
        return pay_currency;
    }

    public String getIpn_callback_url() {
        return ipn_callback_url;
    }

    public String getInvoice_url() {
        return invoice_url;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public String getCancel_url() {
        return cancel_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getToken_id() {
        return token_id;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public String getPartially_paid_url() {
        return partially_paid_url;
    }

    public String getPayout_currency() {
        return payout_currency;
    }

    public Boolean getIs_fixed_rate() {
        return is_fixed_rate;
    }

    public Boolean getIs_fee_paid_by_user() {
        return is_fee_paid_by_user;
    }

    public String getSource() {
        return source;
    }

    public String isCollectUserData() {
        return collect_user_data;
    }

    public static class Builder {
        private String id;
        private String order_id;
        private String order_description;
        private String price_amount;
        private String price_currency;
        private String pay_currency;
        private String ipn_callback_url;
        private String invoice_url;
        private String success_url;
        private String cancel_url;
        private String created_at;
        private String updated_at;
        //NEW
        private String token_id;
        private String customer_email;
        private String partially_paid_url;
        private String payout_currency;
        private Boolean is_fixed_rate;
        private Boolean is_fee_paid_by_user;
        private String source;
        private String collect_user_data;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder orderId(String order_id) {
            this.order_id = order_id;
            return this;
        }

        public Builder orderDescription(String order_description) {
            this.order_description = order_description;
            return this;
        }

        public Builder priceAmount(String price_amount) {
            this.price_amount = price_amount;
            return this;
        }

        public Builder priceCurrency(String price_currency) {
            this.price_currency = price_currency;
            return this;
        }

        public Builder payCurrency(String pay_currency) {
            this.pay_currency = pay_currency;
            return this;
        }

        public Builder ipnCallbackUrl(String ipn_callback_url) {
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }

        public Builder invoiceUrl(String invoice_url) {
            this.invoice_url = invoice_url;
            return this;
        }

        public Builder successUrl(String success_url) {
            this.success_url = success_url;
            return this;
        }

        public Builder cancelUrl(String cancel_url) {
            this.cancel_url = cancel_url;
            return this;
        }

        public Builder createdAt(String created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder updatedAt(String updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public Builder tokenId(String token_id) {
            this.token_id = token_id;
            return this;
        }

        public Builder customerEmail(String customer_email) {
            this.customer_email = customer_email;
            return this;
        }

        public Builder partiallyPaidUrl(String partially_paid_url) {
            this.partially_paid_url = partially_paid_url;
            return this;
        }

        public Builder payoutCurrency(String payout_currency) {
            this.payout_currency = payout_currency;
            return this;
        }

        public Builder fixedRate(Boolean is_fixed_rate) {
            this.is_fixed_rate = is_fixed_rate;
            return this;
        }

        public Builder feePaidByUser(Boolean is_fee_paid_by_user) {
            this.is_fee_paid_by_user = is_fee_paid_by_user;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder collect_user_data(String collect_user_data) {
            this.collect_user_data = collect_user_data;
            return this;
        }

        public InvoiceResponse build() {
            return new InvoiceResponse(this);
        }
    }



}
