package io.github.aks.nowpayment.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
    @JsonProperty("token")
    private String token;
    public AuthResponse(){}
    public AuthResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
