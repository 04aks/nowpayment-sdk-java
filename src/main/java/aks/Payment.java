package aks;

public class Payment {
    private double price_amount;
    private String price_currency;
    private String pay_currency;
    private String ipn_callback_url;
    private String order_id;
    private String order_description;

    private Payment(Builder builder){
        this.price_amount = builder.price_amount;
        this.price_currency = builder.price_currency;
        this.pay_currency = builder.pay_currency;
        this.ipn_callback_url = builder.ipn_callback_url;
        this.order_description = builder.order_description;
        this.order_id = builder.order_id;
    }


    public double getPrice_amount() {
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
    public String getOrder_description() {
        return order_description;
    }
    public String getOrder_id() {
        return order_id;
    }
    
    public static class Builder{
        private double price_amount;
        private String price_currency;
        private String pay_currency;
        private String ipn_callback_url;
        private String order_id;
        private String order_description;

        public Builder price_amount(double price_amount){
            this.price_amount = price_amount;
            return this;
        }
        public Builder price_currency(String price_currency){
            this.price_currency = price_currency;
            return this;
        }
        public Builder pay_currency(String pay_currency){
            this.pay_currency = pay_currency;
            return this;
        }
        public Builder ipn_callback_url(String ipn_callback_url){
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }
        public Builder order_id(String order_id){
            this.order_id = order_id;
            return this;
        }
        public Builder order_description(String order_description){
            this.order_description = order_description;
            return this;
        }


        public Payment build(){
            if(price_amount != 0 && price_currency != null && pay_currency != null){return new Payment(this);}
            return null;
        }

    }
}
