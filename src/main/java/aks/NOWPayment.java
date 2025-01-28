package aks;

import aks.statics.Strings;

public class NOWPayment implements NOWPaymentInterface{
    
    private String email;
    private String password;
    private String key;
    private String token;
    public App app = new App();
    
    private NOWPayment(Builder builder){
        this.email = builder.email;
        this.password = builder.password;
        this.key = builder.key;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getKey() {
        return key;
    }

    //*TOKEN SHIT
    public String getToken() {
        return token;
    }
    private void setToken(String token) {
        this.token = token;
    }


    //! METHODS
    @Override
    public String getAvailableCrypto() {
        return app.utils.connectionGet(Strings.AVAILABLE_CRYPTO_URL, Strings.API_KEY);
    }
    @Override
    public String createInvoice(Invoice invoice) {

        if(getKey() == null){
            throw new IllegalAccessError("API key required");
        }

        String jsonBody = "{\"price_amount\": "+invoice.getPrice_amount()+",\"price_currency\": \"" + invoice.getPrice_currency() + "\",\"order_description\": \"" + invoice.getOrder_description() + "\",\"order_id\": \""+ invoice.getOrder_id() +"\",\"success_url\": \""+ invoice.getSuccess_url() +"\",\"cancel_url\": \""+ invoice.getCancel_url() +"\"}";
        return app.utils.connectionPost(Strings.CREATE_INVOICE, getKey(), jsonBody);
    }
    @Override
    public String authToken() {
        String token = app.authenticate.authenticate(this);
        if(token != null){   
            setToken(token);
            return token;
        }
        return null;
    }
    @Override
    public String checkBalance() {
        //? BRUH CANT MAKE THIS REQUEST FROM WHERE IM FROM (proper dump country), GOTTA CHECK IF IT WORKS
        if(getKey() == null){
            throw new IllegalAccessError("API key might be missing");
        }
        return app.utils.connectionGet(Strings.BALANCE_LINK, getKey());
    }
    @Override
    public String validateAddress(String address, String ticker) {

        /*
         * as for the parameters:
         * 
         * -address -> a crypto wallet address for the corresponding ticker.
         * -ticker -> symbol of the crypto coin of the wallet address provided (Ex: btc for bitcoin)
         * 
         */
        String jsonBody = "{\"address\": \""+ address +"\", \"currency\": \""+ ticker +"\", \"extra_id\":null}";
        return app.utils.connectionPost(Strings.VALID_ADDRESS_LINK, getKey(), jsonBody);
    }




    //! BUILDER
    public static class Builder{

        private String email;
        private String password;
        private String key;
        

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder key(String key){
            this.key = key;
            return this;
        }


        public NOWPayment build(){
            if(email == null && password == null){
                throw new IllegalStateException("Email and Password are Required");
            }
            
            return new NOWPayment(this);
        }

    }
}
