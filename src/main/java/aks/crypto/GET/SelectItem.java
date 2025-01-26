package aks.crypto.GET;

import java.util.HashMap;
import java.util.Scanner;

import aks.App;
import aks.goods.Item;
import aks.statics.Strings;

public class SelectItem {
    App app;
    public SelectItem(App app){
        this.app = app;
    }

    public void inspectItem(HashMap<Integer, Item> items){
        for(int i = 1; i <= items.size(); i++){
            System.out.println("Item #" + (i) + " " + items.get(i).getOrder_description());
        }

        System.out.print("Choose an Item [1 - " + items.size() +"]: ");
        Scanner scanner = new Scanner(System.in);
        int chosenItem = scanner.nextInt();


        System.out.print("Wanna carry on with you purchase of: " + items.get(chosenItem).getOrder_description() +"? [y/n]: ");
        String answer = scanner.next();
        
        if(answer.equalsIgnoreCase("y")) {
            String jsonBody = "{\"price_amount\": "+items.get(chosenItem).getPrice_amount()+",\"price_currency\": \"" + items.get(chosenItem).getPrice_currency() + "\",\"order_description\": \"" + items.get(chosenItem).getOrder_description() + "\"}";
            System.out.println();
            String response = app.utils.connectionPost(Strings.CREATE_INVOICE, Strings.API_KEY, jsonBody);
            System.out.println(response);
        }
    }
}
