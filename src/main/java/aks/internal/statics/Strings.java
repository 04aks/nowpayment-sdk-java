package aks.internal.statics;

public class Strings {
    public static final String AVAILABLE_CRYPTO_URL = "https://api.nowpayments.io/v1/merchant/coins";
    public static final String API_KEY = System.getenv("NOWPAYMENT_KEY");
    public static final String CREATE_INVOICE = "https://api.nowpayments.io/v1/invoice";
    public static final String AUTH_LINK = "https://api.nowpayments.io/v1/auth";
    public static final String BALANCE_LINK = "https://api.nowpayments.io/v1/balance";
    public static final String VALID_ADDRESS_LINK = "https://api.nowpayments.io/v1/payout/validate-address";
    public static final String PAYMENT_LINK = "https://api.nowpayments.io/v1/payment";
    public static final String PAYMENT_VIA_INVOICE = "https://api.nowpayments.io/v1/invoice-payment";
    public static final String PAYMENT_STATUS = "https://api.nowpayments.io/v1/payment/";
    public static final String PAYMENTS_LIST = "https://api.nowpayments.io/v1/payment/?limit=10&page=0&sortBy=created_at&orderBy=asc&dateFrom=2020-01-01&dateTo=2023-07-01&invoiceId=6200264890";
}
