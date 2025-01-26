package aks;

import java.util.Scanner;

import aks.auth.Authenticate;
import aks.crypto.GET.AvailableCrypto;
import aks.profile.User;
import aks.statics.Commands;

public class Main {

    
    public static void main(String[] args) {
        User user = new User();
        Authenticate authenticate = new Authenticate(user);
        AvailableCrypto availableCrypto = new AvailableCrypto();
        

        String response;
        Scanner scanner = new Scanner(System.in);
        response = scanner.nextLine();
        
        
        switch (response) {
            case Commands.AUTH: authenticate.startAuth(); break;
            case Commands.AVA_CURR: availableCrypto.getAvailableCurrencies(); break;
        
            default:
                break;
        }

        // scanner.close();
    }

}