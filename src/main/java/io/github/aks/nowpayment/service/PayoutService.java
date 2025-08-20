package io.github.aks.nowpayment.service;

import io.github.aks.nowpayment.auth.AuthProvider;
import io.github.aks.nowpayment.model.payouts.balance.BalanceResponse;
import io.github.aks.nowpayment.transport.HttpTransport;
import io.github.aks.nowpayment.util.JsonSerializer;
import io.github.aks.nowpayment.util.Paths;

public class PayoutService {
    private HttpTransport transport;
    private AuthProvider auth;
    private JsonSerializer json;
    public PayoutService(HttpTransport transport, AuthProvider auth, JsonSerializer json){
        this.transport = transport;
        this.auth = auth;
        this.json = json;
    }

    public BalanceResponse balance(){
        // returns an empty string when you have no balance on NOWPayment
        String response = transport.get(Paths.PATH_BALANCE, auth.getAuthHeaders());
        return json.fromJson(response, BalanceResponse.class);
    }
}
