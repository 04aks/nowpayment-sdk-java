package aks;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import aks.internal.App;
import aks.internal.Invoice;
import aks.internal.NOWPaymentInterface;
import aks.internal.Payment;
import aks.internal.PaymentViaInvoice;
import aks.internal.Payout;
import aks.internal.statics.Strings;

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
    public Map<String, Object> createInvoice(Invoice invoice) {

        Map<String, Object> json = new HashMap<>();
        json.put("price_amount", invoice.getPrice_amount());
        json.put("price_currency", invoice.getPrice_currency());
        json.put("order_description", invoice.getOrder_description());
        json.put("order_id", invoice.getOrder_id());
        json.put("cancel_url", invoice.getCancel_url());
        json.put("success_url", invoice.getSuccess_url());
        json.put("ipn_callback_url", invoice.getIpn_callback_url());

        // ELIMINATE NULL KEYS
        json.entrySet().removeIf(entry -> entry.getValue() == null);

        String response = app.utils.connectionPost(Strings.CREATE_INVOICE, getKey(), new JSONObject(json).toString());
        
        JSONObject jsonObject = new JSONObject(response);
        Map<String, Object> map = jsonObject.toMap();
        
        invoice.setResponseJson(map);
        return map;
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
        // GOTTA WHITELIST AN IP ADDRESS IN https://nowpayment.io
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
    @Override
    public String convertFiatToCrypto(double amount, String from, String to) {
        /*
         * raw ticket for the variable 'String to'
         * (Ex: usdt) NOT "usdtsol" ....
         */
        String url = "https://api.nowpayments.io/v1/estimate?amount="+ amount +"&currency_from="+ from +"&currency_to=" + to;
        return app.utils.connectionGet(url, getKey());
    }
    @Override
    public Map<String, Object> createPayment(Payment payment) {
        /*
         * pay_currency should include the network 'code' for some coins
         * case with USDT:
         *      pay_currency = "usdt" sends an Error
         *      pay_currency = "usdtbsc" goes through
         */

        // CREATE POST JSON
        Map<String, Object> json = new HashMap<>();
        json.put("price_amount", payment.getPrice_amount());
        json.put("price_currency", payment.getPrice_currency());
        json.put("pay_currency", payment.getPay_currency());
        json.put("ipn_callback_url", payment.getIpn_callback_url());
        json.put("order_id", payment.getOrder_id());
        json.put("order_description", payment.getOrder_description());

        // GET RID OF NULL KEYS (OPTIONAL KEYS IN THE API DOCs)
        json.entrySet().removeIf(entry -> entry.getValue() == null);

        String response = app.utils.connectionPost(Strings.PAYMENT_LINK, getKey(), new JSONObject(json).toString());
        
        JSONObject jsonObject = new JSONObject(response);
        Map<String, Object> map = jsonObject.toMap();

        payment.setResponseJson(map);
        return map;
    }
    @Override
    public Map<String, Object> createPaymentWithInvoice(PaymentViaInvoice paymentViaInvoice) {

        Map<String, Object> json = new HashMap<>();
        json.put("iid", paymentViaInvoice.getInvoice_id());
        json.put("pay_currency", paymentViaInvoice.getPay_currency());
        json.put("purchase_id", paymentViaInvoice.getPurchase_id());
        json.put("order_description", paymentViaInvoice.getOrder_description());
        json.put("customer_email", paymentViaInvoice.getCustomer_email());
        json.put("payout_address", paymentViaInvoice.getPayout_address());
        json.put("payout_extra_id", paymentViaInvoice.getPayout_extra_id());
        json.put("payout_currency", paymentViaInvoice.getPayout_currency());

        // KICK OUT THE PAGANS
        json.entrySet().removeIf(entry -> entry.getValue() == null);

        String response = app.utils.connectionPost(Strings.PAYMENT_VIA_INVOICE, getKey(), new JSONObject(json).toString());
        
        JSONObject jsonObject = new JSONObject(response);
        Map<String, Object> map = jsonObject.toMap();
        return map;
    }
    @Override
    public Map<String, Object> getPaymentStatusById(String id) {
        //! GOTTA CHECK IF THIS WORKS, LATER
        String response = app.utils.connectionGet(Strings.PAYMENT_STATUS + id, getKey());
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.toMap();
    }
    @Override
    public Map<String, Object> getPaymentsList(String token) {
        /*
         * token is a parameter because
         * it is changing 
         * the token expires every 5 minutes I believe
         */
        String response = app.utils.authConnectionGet(Strings.PAYMENTS_LIST, getKey(), token);
        System.out.println(response);
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.toMap();
    }
    @Override
    public Map<String, Object> createMassPayout(Payout payout) {
        /*
         * Obviously you need to have balance 
         * in https://NOWpayment.io for this to work
         */
        if(getToken() == null){
            authToken();
            System.out.println("cooked a token rq");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("ipn_callback_url", payout.getIpn_callback_url());
        map.put("withdrawals", payout.getWithdrawals());
        
        // PURGE NULLs
        map.entrySet().removeIf(entry -> entry.getValue() == null);
        
        String r = app.utils.connectionPost(Strings.CREATE_PAYOUT, getKey(), getToken(), map);
        JSONObject object = new JSONObject(r);
        return object.toMap();
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
            if(key == null || key.isEmpty()){
                throw new IllegalAccessError("API key required");
            }
            
            return new NOWPayment(this);
        }

    }
}
