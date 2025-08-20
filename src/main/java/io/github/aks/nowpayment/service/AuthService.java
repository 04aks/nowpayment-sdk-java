package io.github.aks.nowpayment.service;

import io.github.aks.nowpayment.model.auth.AuthRequest;
import io.github.aks.nowpayment.model.auth.AuthResponse;
import io.github.aks.nowpayment.transport.HttpTransport;
import io.github.aks.nowpayment.util.JsonSerializer;
import io.github.aks.nowpayment.util.Paths;
import java.util.HashMap;

public class AuthService {
    private HttpTransport transport;
    private JsonSerializer json;
    public AuthService(HttpTransport transport, JsonSerializer json){
        this.transport = transport;
        this.json = json;
    }
    public AuthResponse authenticate(AuthRequest req){
        String body = json.toJson(req);
        String response = transport.post(Paths.PATH_AUTH, body, null);
        return json.fromJson(response, AuthResponse.class);
    }
}
