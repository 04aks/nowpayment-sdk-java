package io.github.aks.nowpayment.util;

import io.github.aks.nowpayment.exceptions.InvalidCurrencyException;

import java.util.Set;

public class Tickers {
    
    public static final String USA_DOLLAR = "usd"; 
    public static final String EUR_CURRENCY = "eur";
    public static final String BITCOIN = "btc";
    public static final String ETHEREUM = "eth";
    public static final String SOLANA = "sol";
    public static final String USDT_ETH = "usdterc20";
    public static final String USDT_SOLANA = "usdtsol";
    public static final String USDT_BNB = "usdtbsc";

    public static final Set<String> SUPPORTED_CURRENCIES =
            Set.of(BITCOIN, ETHEREUM, SOLANA, USDT_ETH,USDT_BNB, USDT_SOLANA);
    public static void validCurrency(String currency){
        if(!SUPPORTED_CURRENCIES.contains(currency)){
            throw new InvalidCurrencyException(currency);
        }
    }
}
