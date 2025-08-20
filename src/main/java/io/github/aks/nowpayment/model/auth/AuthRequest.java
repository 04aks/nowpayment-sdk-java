package io.github.aks.nowpayment.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    public AuthRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}

