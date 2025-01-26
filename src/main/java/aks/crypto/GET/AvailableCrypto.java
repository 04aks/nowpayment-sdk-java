package aks.crypto.GET;

import aks.statics.Strings;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AvailableCrypto {
    
    public void getAvailableCurrencies(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url(Strings.AVAILABLE_CRYPTO_URL)
            .get()
            .header("x-api-key", "7WYQQFA-KN1M0BC-K7GEFH0-9MDY9Z0")
            .build();


        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                System.out.println(response.body().string());
            }else{
                System.out.println(response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
