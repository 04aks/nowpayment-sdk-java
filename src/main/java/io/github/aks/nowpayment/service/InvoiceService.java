package io.github.aks.nowpayment.service;

import io.github.aks.nowpayment.auth.AuthProvider;
import io.github.aks.nowpayment.model.InvoiceRequest;
import io.github.aks.nowpayment.model.InvoiceResponse;
import io.github.aks.nowpayment.transport.HttpTransport;
import io.github.aks.nowpayment.util.JsonSerializer;
import io.github.aks.nowpayment.util.Paths;

public class InvoiceService {
    private HttpTransport transport;
    private JsonSerializer json;
    private AuthProvider auth;
    public InvoiceService(HttpTransport transport, AuthProvider auth, JsonSerializer json){
        this.transport = transport;
        this.json = json;
        this.auth = auth;
    }
    public InvoiceResponse createInvoice(InvoiceRequest req){
        String body = json.toJson(req);
        String response = transport.post(Paths.PATH_INVOICE, body, auth.getAuthHeaders());
        return json.fromJson(response, InvoiceResponse.class);
    }
}
