package io.github.aks.nowpayment.client;

import io.github.aks.nowpayment.auth.AuthProvider;
import io.github.aks.nowpayment.service.InvoiceService;
import io.github.aks.nowpayment.service.PaymentService;
import io.github.aks.nowpayment.transport.HttpTransport;
import io.github.aks.nowpayment.util.JsonSerializer;

public class NOWPaymentClient {
    private final HttpTransport transport;
    private final AuthProvider auth;
    private final JsonSerializer json;

    public NOWPaymentClient(String baseUrl, String apiKey){
        this.transport = new HttpTransport(baseUrl);
        this.auth = new AuthProvider(apiKey);
        this.json = new JsonSerializer();
    }

    public PaymentService payments(){
        return new PaymentService(transport, auth, json);
    }
    public InvoiceService invoices(){
        return new InvoiceService(transport, auth, json);
    }
}
