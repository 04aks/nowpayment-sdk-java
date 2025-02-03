package aks.internal;

import java.util.List;

public class Payout {
    private String ipn_callback_url;
    private List<Withdrawal> withdrawals;

    private Payout(Builder builder) {
        this.ipn_callback_url = builder.ipn_callback_url;
        this.withdrawals = builder.withdrawals;
    }

    public String getIpn_callback_url() {
        return ipn_callback_url;
    }
    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }


    public static class Builder{
        private String ipn_callback_url;
        private List<Withdrawal> withdrawals;

        public Builder ipn_callback_url(String ipn_callback_url){
            this.ipn_callback_url = ipn_callback_url;
            return this;
        }

        public Builder withdrawals(List<Withdrawal> withdrawals){
            this.withdrawals = withdrawals;
            return this;
        }

        public Payout build(){
            if(withdrawals != null) return new Payout(this);

            return null;
        }
    }
}
