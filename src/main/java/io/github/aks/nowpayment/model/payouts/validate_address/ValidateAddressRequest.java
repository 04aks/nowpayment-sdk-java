package io.github.aks.nowpayment.model.payouts.validate_address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateAddressRequest {
    @JsonProperty("address")
    private String address;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("extra_id")
    private String extra_id;

    public ValidateAddressRequest(String address, String currency, String extra_id){
        this.address = address;
        this.currency = currency;
        this.extra_id = extra_id;
    }

    public String getAddress() {
        return address;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExtra_id() {
        return extra_id;
    }
}
