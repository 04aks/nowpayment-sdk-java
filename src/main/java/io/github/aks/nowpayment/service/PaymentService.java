package io.github.aks.nowpayment.service;

import io.github.aks.nowpayment.auth.AuthProvider;
import io.github.aks.nowpayment.model.PaymentRequest;
import io.github.aks.nowpayment.transport.HttpTransport;
import io.github.aks.nowpayment.util.JsonSerializer;

public class PaymentService {
    private final HttpTransport transport;
    private final AuthProvider auth;
    private final JsonSerializer json;
    public PaymentService(HttpTransport transport, AuthProvider auth, JsonSerializer json){
        this.transport = transport;
        this.auth = auth;
        this.json = json;
    }
    public String createPayment(PaymentRequest request){
        String body = json.toJson(request);
        System.out.println(body);
        return transport.post("/payment", body, auth.getAuthHeaders());
    }
}
