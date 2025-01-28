package aks.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aks.NOWPayment;
import aks.statics.Strings;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Authenticate {
    public Authenticate(){
    }


    public String authenticate(NOWPayment nowPayment){
        System.out.println("checking your account ...");
        OkHttpClient client = new OkHttpClient();

        MediaType media = MediaType.parse("application/json");
        String jsonBody = "{\"email\": \"" + nowPayment.getEmail() + "\",\"password\": \"" + nowPayment.getPassword() + "\"}";
        RequestBody requestBody = RequestBody.create(jsonBody, media);


        Request request = new Request.Builder()
            .url(Strings.AUTH_LINK)
            .post(requestBody)
            .build();

        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){

                ObjectMapper om = new ObjectMapper();
                JsonNode main = om.readTree(response.body().string());

                if(main.has("token")){
                    return main.get("token").asText();
                }
            }
            else{
                throw new IllegalAccessException("Couldn't authenticate your request, check you email and password");
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return null;
            
    }

}
