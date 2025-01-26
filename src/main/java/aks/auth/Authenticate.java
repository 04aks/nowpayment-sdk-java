package aks.auth;

import java.util.Scanner;

import aks.profile.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Authenticate {
    User user;
    public Authenticate(User user){
        this.user = user;
    }

    public void startAuth(){
        typeCred(user);
    }

    void typeCred(User user){
        System.out.print("Type in you email: ");
        Scanner scanner = new Scanner(System.in);
        user.setEmail(scanner.nextLine());

        System.out.print("Type in your Password: ");
        user.setPass(scanner.nextLine());

        authenticate();
        scanner.close();
    }


    void authenticate(){
        System.out.println("checking your account ...");
        OkHttpClient client = new OkHttpClient();

        MediaType media = MediaType.parse("application/json");
        String jsonBody = "{\"email\": \"" + user.getEmail() + "\",\"password\": \"" + user.getPass() + "\"}";
        RequestBody requestBody = RequestBody.create(jsonBody, media);


        Request request = new Request.Builder()
            .url("https://api.nowpayments.io/v1/auth")
            .post(requestBody)
            .build();

        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                System.out.println(response.body().string());
            }
            else{
                System.out.println(response);
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
            
    }

}
