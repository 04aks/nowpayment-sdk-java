package aks.internal;

public class Withdrawal {
    private String address;
    private String currency;
    private double amount;
    private double fiat_amount;
    private String fiat_currency;
    private String ipn_callback_url;

    private Withdrawal(Builder builder){
        this.address = builder.address;
        this.currency = builder.currency;
        this.amount = builder.amount;
        this.fiat_amount = builder.fiat_amount;
        this.fiat_currency = builder.fiat_currency;
        this.ipn_callback_url = builder.ipn_callback_url;
    }

    public String getAddress() {
        return address;
    }
    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    public double getFiat_amount() {
        return fiat_amount;
    }
    public String getFiat_currency() {
        return fiat_currency;
    }
    public String getIpn_callback_url() {
        return ipn_callback_url;
    }

    public static class Builder{
        private String address;
        private String currency;
        private double amount;
        private double fiat_amount;
        private String fiat_currency;
        private String ipn_callback_url;

        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder currency(String currency){
            this.currency = currency;
            return this;
        }
        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }
        public Builder fiat_amount(double fiat_amount){
            this.fiat_amount = fiat_amount;
            return this;
        }
        public Builder fiat_currency(String fiat_currency){
            this.fiat_currency = fiat_currency;
            return this;
        }
        public Builder ipn_callback_url(String ipn_callback_url){
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }


        public Withdrawal build(){
            if(address != null && currency != null && amount != 0){
                return new Withdrawal(this);
            }

            return null;
        }
    } 
}
