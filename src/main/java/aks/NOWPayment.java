package aks;

import aks.auth.Authenticate;
import aks.goods.Invoice;
import aks.statics.Strings;

public class NOWPayment implements NOWPaymentInterface{
    
    private String email;
    private String password;
    private String token;
    public App app = new App();
    
    private NOWPayment(Builder builder){
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    //*TOKEN SHIT
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }


    //! METHODS
    @Override
    public String getAvailableCrypto() {
        return app.utils.connectionGet(Strings.AVAILABLE_CRYPTO_URL, Strings.API_KEY);
    }
    @Override
    public String createInvoice(Invoice invoice) {
        String jsonBody = "{\"price_amount\": "+invoice.getPrice_amount()+",\"price_currency\": \"" + invoice.getPrice_currency() + "\",\"order_description\": \"" + invoice.getOrder_description() + "\",\"order_id\": \""+ invoice.getOrder_id() +"\",\"success_url\": \""+ invoice.getSuccess_url() +"\",\"cancel_url\": \""+ invoice.getCancel_url() +"\"}";
        return app.utils.connectionPost(Strings.CREATE_INVOICE, Strings.API_KEY, jsonBody);
    }





    //! BUILDER
    public static class Builder{

        private String email;
        private String password;
        private String token;
        Authenticate authenticate = new Authenticate();

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }


        public NOWPayment build(){
            if(email == null && password == null){
                throw new IllegalStateException("Email and Password are Required");
            }
            
            
            
            try{
                token = authenticate.authenticate(email, password);
                if(token != null){
                    NOWPayment nowPayment = new NOWPayment(this);
                    nowPayment.setToken(token);
                    return nowPayment;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            return null;
        }

    }
}
