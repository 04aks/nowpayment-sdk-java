package aks.statics;

public class Strings {
    public static final String AVAILABLE_CRYPTO_URL = "https://api.nowpayments.io/v1/merchant/coins";
    public static final String API_KEY = System.getenv("NOWPAYMENT_KEY");
    public static final String CREATE_INVOICE = "https://api.nowpayments.io/v1/invoice";
    public static final String AUTH_LINK = "https://api.nowpayments.io/v1/auth";
    public static final String BALANCE_LINK = "https://api.nowpayments.io/v1/balance";
    public static final String VALID_ADDRESS_LINK = "https://api.nowpayments.io/v1/payout/validate-address";
}
