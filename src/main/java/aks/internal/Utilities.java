package aks.internal;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Utilities {
    
    public String connectionGet(String url, String API_KEY){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url(url)
        .get()
        .addHeader("x-api-key", API_KEY)
        .build();

        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
            else{
                System.out.println("[GET] Something Went Wrong " + response.body().string());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public String connectionPost(String url, String API_KEY, String jsonBody){
        OkHttpClient client = new OkHttpClient();

        MediaType json = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(jsonBody, json);

        Request request = new Request.Builder()
        .url(url)
        .header("x-api-key", API_KEY)
        .post(requestBody)
        .build();

        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }else{
                System.out.println("[POST] Something Went Wrong! " + response.body().string());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String authConnectionGet(String url, String API_KEY, String token){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url(url)
            .header("x-api-key", API_KEY)
            .header("Authorization", "Bearer " + token)
            .build();


            try(Response response = client.newCall(request).execute()){
                if(response.isSuccessful()){
                    return response.body().string();
                }else{
                    System.out.println(response.body().string());
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
    }
}
