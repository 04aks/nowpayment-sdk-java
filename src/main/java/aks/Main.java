package aks;

import java.util.Scanner;

import aks.auth.Authenticate;
import aks.comms.Commands;
import aks.profile.User;

public class Main {

    
    public static void main(String[] args) {
        User user = new User();
        Authenticate authenticate = new Authenticate(user);
        

        String response;
        Scanner scanner = new Scanner(System.in);
        response = scanner.nextLine();
        
        
        switch (response) {
            case Commands.AUTH: authenticate.startAuth(); break;
        
            default:
                break;
        }

        // scanner.close();
    }

}