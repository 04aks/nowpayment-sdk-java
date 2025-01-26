package aks;

import java.util.Scanner;

import aks.statics.Commands;

public class Main {

    
    public static void main(String[] args) {
        App app = new App();

        

        String response;
        Scanner scanner = new Scanner(System.in);
        response = scanner.nextLine();
        
        
        switch (response) {
            case Commands.AUTH: app.authenticate.startAuth(); break;
            case Commands.AVA_CURR: app.availableCrypto.getAvailableCurrencies(); break;
            case Commands.SELECT_ITEM: app.selectItem.inspectItem(app.testClassItems.getItems());
        
            default:
                break;
        }

        // scanner.close();
    }

}