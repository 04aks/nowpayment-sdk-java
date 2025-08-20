package io.github.aks.nowpayment.transport;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HttpTransport {

    private final OkHttpClient client;
    private final String baseUrl;

    public HttpTransport(String baseUrl){
        this.baseUrl = baseUrl;
        client = new OkHttpClient();
    }

    public String get(String path, Map<String, String> headers){

        Request.Builder requestBuilder = new Request.Builder()
                .url(baseUrl + path)
                .get();

        headers.forEach(requestBuilder::addHeader);
        Request request = requestBuilder.build();
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){return response.body().string();}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public String post(String path, Object body, Map<String, String> headers){

        MediaType json = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(body.toString(), json);

        Request.Builder requestBuilder = new Request.Builder()
                .url(baseUrl + path)
                .post(requestBody);

        if(headers != null) headers.forEach(requestBuilder::addHeader);
        Request request = requestBuilder.build();
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                return response.body().string();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }
}
