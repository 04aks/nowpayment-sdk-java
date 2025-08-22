package io.github.aks.nowpayment.exceptions;

public class InvalidCurrencyException extends RuntimeException{
    public InvalidCurrencyException(String currency){
        super("The currency " + currency.toUpperCase() + " is invalid or unsupported.");
    }
}
