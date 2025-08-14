package io.github.aks.nowpayment.model;

import java.math.BigDecimal;

public class PaymentResponse {
    private String payment_id;
    private String payment_status;
    private String pay_address;
    private BigDecimal price_amount;
    private String price_currency;
    private BigDecimal pay_amount;
    private String pay_currency;
    private String order_id;
    private String order_description;
    private String ipn_callback_url;
    private String created_at;
    private String updated_at;
    private String purchase_id;
    private BigDecimal amount_received;
    private String payin_extra_id;
    private String smart_contract;
    private String network;
    private Integer network_precision;
    private Integer time_limit; // DON'T KNOW PROPER DATA TYPE YET
    private BigDecimal burning_percent; // CASE ABOVE ^
    private String expiration_estimate_date;
    // NEW
    private String customer_email;
    private Boolean is_fixed_rate;
    private Boolean is_fee_paid_by_user;
    private String valid_until;
    private String type;
    private String product;
    private String origin_ip;

    private PaymentResponse(){}
    private PaymentResponse(Builder builder){
        this.payment_id = builder.payment_id;
        this.payment_status = builder.payment_status;
        this.pay_address = builder.pay_address;
        this.price_amount = builder.price_amount;
        this.price_currency = builder.price_currency;
        this.pay_amount = builder.pay_amount;
        this.pay_currency = builder.pay_currency;
        this.order_id = builder.order_id;
        this.order_description = builder.order_description;
        this.ipn_callback_url = builder.ipn_callback_url;
        this.customer_email = builder.customer_email;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
        this.purchase_id = builder.purchase_id;
        this.amount_received = builder.amount_received;
        this.payin_extra_id = builder.payin_extra_id;
        this.smart_contract = builder.smart_contract;
        this.network = builder.network;
        this.network_precision = builder.network_precision;
        this.time_limit = builder.time_limit;
        this.burning_percent = builder.burning_percent;
        this.expiration_estimate_date = builder.expiration_estimate_date;
        this.is_fixed_rate = builder.is_fixed_rate;
        this.is_fee_paid_by_user = builder.is_fee_paid_by_user;
        this.valid_until = builder.valid_until;
        this.type = builder.type;
        this.product = builder.product;
        this.origin_ip = builder.origin_ip;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getPay_address() {
        return pay_address;
    }

    public BigDecimal getPrice_amount() {
        return price_amount;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public BigDecimal getPay_amount() {
        return pay_amount;
    }

    public String getPay_currency() {
        return pay_currency;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_description() {
        return order_description;
    }

    public String getIpn_callback_url() {
        return ipn_callback_url;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getPurchase_id() {
        return purchase_id;
    }

    public BigDecimal getAmount_received() {
        return amount_received;
    }

    public String getPayin_extra_id() {
        return payin_extra_id;
    }

    public String getSmart_contract() {
        return smart_contract;
    }

    public String getNetwork() {
        return network;
    }

    public Integer getNetwork_precision() {
        return network_precision;
    }

    public Integer getTime_limit() {
        return time_limit;
    }

    public BigDecimal getBurning_percent() {
        return burning_percent;
    }

    public String getExpiration_estimate_date() {
        return expiration_estimate_date;
    }

    public Boolean getIs_fixed_rate() {
        return is_fixed_rate;
    }

    public Boolean getIs_fee_paid_by_user() {
        return is_fee_paid_by_user;
    }

    public String getValid_until() {
        return valid_until;
    }

    public String getType() {
        return type;
    }

    public String getProduct() {
        return product;
    }

    public String getOrigin_ip() {
        return origin_ip;
    }

    public static class Builder{
        private String payment_id;
        private String payment_status;
        private String pay_address;
        private BigDecimal price_amount;
        private String price_currency;
        private BigDecimal pay_amount;
        private String pay_currency;
        private String order_id;
        private String order_description;
        private String ipn_callback_url;
        private String created_at;
        private String updated_at;
        private String purchase_id;
        private BigDecimal amount_received;
        private String payin_extra_id;
        private String smart_contract;
        private String network;
        private Integer network_precision;
        private Integer time_limit; // DON'T KNOW PROPER DATA TYPE YET
        private BigDecimal burning_percent; // CASE ABOVE ^
        private String expiration_estimate_date;
        //new
        private String customer_email;
        private Boolean is_fixed_rate;
        private Boolean is_fee_paid_by_user;
        private String valid_until;
        private String type;
        private String product;
        private String origin_ip;

        public Builder payment_id(String payment_id){
            this.payment_id = payment_id;
            return this;
        }
        public Builder payment_status(String payment_status){
            this.payment_status = payment_status;
            return this;
        }
        public Builder pay_address(String pay_address){
            this.pay_address = pay_address;
            return this;
        }
        public Builder price_amount(BigDecimal price_amount){
            this.price_amount = price_amount;
            return this;
        }
        public Builder price_currency(String price_currency){
            this.price_currency = price_currency;
            return this;
        }
        public Builder pay_amount(BigDecimal pay_amount){
            this.pay_amount = pay_amount;
            return this;
        }
        public Builder pay_currency(String pay_currency){
            this.pay_currency = pay_currency;
            return this;
        }
        public Builder order_id(String order_id){
            this.order_id = order_id;
            return this;
        }
        public Builder order_description(String order_description) {
            this.order_description = order_description;
            return this;
        }
        public Builder ipn_callback_url(String ipn_callback_url) {
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }

        public Builder customer_email(String customer_email){
            this.customer_email = customer_email;
            return  this;
        }

        public Builder created_at(String created_at) {
            this.created_at = created_at;
            return this;
        }
        public Builder updated_at(String updated_at) {
            this.updated_at = updated_at;
            return this;
        }
        public Builder purchase_id(String purchase_id) {
            this.purchase_id = purchase_id;
            return this;
        }
        public Builder amount_received(BigDecimal amount_received) {
            this.amount_received = amount_received;
            return this;
        }
        public Builder payin_extra_id(String payin_extra_id) {
            this.payin_extra_id = payin_extra_id;
            return this;
        }
        public Builder smart_contract(String smart_contract) {
            this.smart_contract = smart_contract;
            return this;
        }
        public Builder network(String network) {
            this.network = network;
            return this;
        }
        public Builder network_precision(Integer network_precision) {
            this.network_precision = network_precision;
            return this;
        }
        public Builder time_limit(Integer time_limit) {
            this.time_limit = time_limit;
            return this;
        }
        public Builder burning_percent(BigDecimal burning_percent) {
            this.burning_percent = burning_percent;
            return this;
        }
        public Builder expiration_estimate_date(String expiration_estimate_date) {
            this.expiration_estimate_date = expiration_estimate_date;
            return this;
        }
        public Builder is_fixed_rate(Boolean is_fixed_rate) {
            this.is_fixed_rate = is_fixed_rate;
            return this;
        }

        public Builder is_fee_paid_by_user(Boolean is_fee_paid_by_user) {
            this.is_fee_paid_by_user = is_fee_paid_by_user;
            return this;
        }

        public Builder valid_until(String valid_until) {
            this.valid_until = valid_until;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder product(String product) {
            this.product = product;
            return this;
        }

        public Builder origin_ip(String origin_ip) {
            this.origin_ip = origin_ip;
            return this;
        }


        public PaymentResponse build(){
            return new PaymentResponse(this);
        }
    }
}
