package io.github.aks.nowpayment.model.payouts.balance;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.HashMap;

public class BalanceResponse {
    private HashMap<String, BalanceInfo> balance = new HashMap<>();

    @JsonAnySetter
    public void addBalance(String ticker, BalanceInfo balanceInfo){
        balance.put(ticker, balanceInfo);
    }

    public HashMap<String, BalanceInfo> getBalance() {
        return balance;
    }

    public static class BalanceInfo{
        @JsonProperty("amount")
        private BigDecimal amount;
        @JsonProperty("pendingAmount")
        private BigDecimal pendingAmount;
        public BalanceInfo(BigDecimal amount, BigDecimal pendingAmount){
            this.amount = amount;
            this.pendingAmount = pendingAmount;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public BigDecimal getPendingAmount() {
            return pendingAmount;
        }
    }
}
