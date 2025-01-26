package aks.crypto.POST;

import java.util.HashMap;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Desktop;
import java.net.URI;
import aks.App;
import aks.goods.Item;
import aks.statics.Strings;

public class SelectItem {
    App app;
    public SelectItem(App app){
        this.app = app;
    }

    public String inspectItem(HashMap<Integer, Item> items){
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

            return app.utils.connectionPost(Strings.CREATE_INVOICE, Strings.API_KEY, jsonBody);
            
        }

        return null;
    }

    public String getInvoiceUrl(HashMap<Integer, Item> items){
        
        String json = inspectItem(items);
        ObjectMapper om = new ObjectMapper();
        try{
            JsonNode main = om.readTree(json);
            return main.get("invoice_url").asText();
        }catch(Exception e){
            e.printStackTrace();
        }     
        return null;
    }


    public void browseInvoiceURl(String link){

        URI uri = URI.create(link);
        
        try{   
             
            if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                Desktop.getDesktop().browse(uri);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
