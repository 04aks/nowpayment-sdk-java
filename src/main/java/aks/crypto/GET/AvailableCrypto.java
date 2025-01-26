package aks.crypto.GET;

import aks.App;
import aks.statics.Strings;

public class AvailableCrypto {
    
    
    App app;
    public AvailableCrypto(App app){
        this.app = app;   
    }
    
    public void getAvailableCurrencies(){

        String availableCryptos = app.utils.connectionGet(Strings.AVAILABLE_CRYPTO_URL, Strings.API_KEY);
        System.out.println(availableCryptos);
    }
}
