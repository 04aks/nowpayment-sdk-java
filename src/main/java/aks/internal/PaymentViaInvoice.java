package aks.internal;

import java.util.Map;

import org.json.JSONObject;

public class PaymentViaInvoice {

    private String invoice_id;
    private String pay_currency;
    private String purchase_id;
    private String order_description;
    private String customer_email;
    private String payout_address;
    private String payout_extra_id;
    private String payout_currency;

    private PaymentViaInvoice(Builder builder){
        this.invoice_id = builder.invoice_id;
        this.pay_currency = builder.pay_currency;
        this.purchase_id = builder.purchase_id;
        this.order_description = builder.order_description;
        this.customer_email = builder.customer_email;
        this.payout_address = builder.payout_address;
        this.payout_extra_id = builder.payout_extra_id;
        this.payout_currency = builder.payout_currency;
    }   

    public String getInvoice_id() {
        return invoice_id;
    }
    public String getPurchase_id() {
        return purchase_id;
    }
    public String getPay_currency() {
        return pay_currency;
    }
    public String getOrder_description() {
        return order_description;
    }
    public String getCustomer_email() {
        return customer_email;
    }
    public String getPayout_address() {
        return payout_address;
    }
    public String getPayout_currency() {
        return payout_currency;
    }
    public String getPayout_extra_id() {
        return payout_extra_id;
    }



    public static class Builder{

        private String invoice_id;
        private String pay_currency;
        private String purchase_id;
        private String order_description;
        private String customer_email;
        private String payout_address;
        private String payout_extra_id;
        private String payout_currency;
        
        private Invoice invoice;
        private Payment payment;

        public Builder invoice_id(Invoice invoice){

            this.invoice = invoice;

            JSONObject jsonObject = new JSONObject(invoice.getResponseJson());
            Map<String, Object> map = jsonObject.toMap();
            
            this.invoice_id = map.get("id").toString();
            return this;
        }
        public Builder pay_currency(String pay_currency){
            this.pay_currency = pay_currency;
            return this;
        }
        public Builder purchase_id(Payment payment){

            this.payment = payment;

            JSONObject jsonObject = new JSONObject(payment.getResponseJson());
            Map<String, Object> map = jsonObject.toMap();

            this.purchase_id = map.get("purchase_id").toString();
            return this;
        }
        public Builder order_description(String order_description){
            this.order_description = order_description;
            return this;
        }
        public Builder customer_email(String customer_email){
            this.customer_email = customer_email;
            return this;
        }
        public Builder payout_address(String payout_address){
            this.payout_address = payout_address;
            return this;
        }
        public Builder payout_extra_id(String payout_extra_id){
            this.payout_extra_id = payout_extra_id;
            return this;
        }
        public Builder payout_currency(String payout_currency){
            this.payout_currency = payout_currency;
            return this;
        }


        public PaymentViaInvoice build(){
            if(invoice != null && payment != null && pay_currency != null) return new PaymentViaInvoice(this);
            return null;
        }

    }
}
