package io.github.aks.nowpayment.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthProvider {
    private final String apiKey;
    public AuthProvider(String apiKey){
        this.apiKey = apiKey;
    }

    public Map<String, String> getAuthHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("x-api-key", apiKey);
        return headers;
    }
}
