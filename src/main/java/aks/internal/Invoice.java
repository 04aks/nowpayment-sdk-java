package aks.internal;

import java.util.Map;

public class Invoice {
    
    private double price_amount;
    private String price_currency;
    private String order_description;
    private String order_id;
    private String ipn_callback_url;
    private String success_url;
    private String cancel_url;

    private Map<String, Object> responseJson;

    private Invoice(Builder builder){
        this.price_amount = builder.price_amount;
        this.price_currency = builder.price_currency;
        this.order_description = builder.order_description;
        this.order_id = builder.order_id;
        this.ipn_callback_url = builder.ipn_callback_url;
        this.success_url = builder.success_url;
        this.cancel_url = builder.cancel_url;
    }


    public double getPrice_amount() {
        return price_amount;
    }
    public String getPrice_currency() {
        return price_currency;
    }
    public String getOrder_description() {
        return order_description;
    }
    public String getOrder_id() {
        return order_id;
    }
    public String getIpn_callback_url() {
        return ipn_callback_url;
    }
    public String getCancel_url() {
        return cancel_url;
    }
    public String getSuccess_url() {
        return success_url;
    }


    public Map<String, Object> getResponseJson() {
        return responseJson;
    }
    public void setResponseJson(Map<String, Object> responseJson) {
        this.responseJson = responseJson;
    }




    //! BUILDER 
    public static class Builder{
        private double price_amount; //required
        private String price_currency; //required
        private String order_description;
        private String order_id;
        private String ipn_callback_url;
        private String success_url;
        private String cancel_url;

        public Builder price_amount(double price_amount){
            this.price_amount = price_amount;
            return this;
        }
        public Builder price_currency(String price_currency){
            this.price_currency = price_currency;
            return this;
        }
        public Builder order_description(String order_description){
            this.order_description = order_description;
            return this;
        }
        public Builder order_id(String order_id){
            this.order_id = order_id;
            return this;
        }
        public Builder ipn_callback_url(String ipn_callback_url){
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }
        public Builder success_url(String success_url){
            this.success_url = success_url;
            return this;
        }
        public Builder cancel_url(String cancel_url){
            this.cancel_url = cancel_url;
            return this;
        }


        public Invoice build(){

            // THESE VARIABLES ARE REQUIRED TO CREATE AN INVOICE OTHERWISE U AINT GETTING PAID LIL BRO
            if(price_amount != 0 && price_currency != null){
                return new Invoice(this);
            }
            

            return null;
        }
    }
}
