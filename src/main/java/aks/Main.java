package aks;

import aks.goods.Invoice;

public class Main {

    
    public static void main(String[] args) {
        // App app = new App();

        

        // String response;
        // Scanner scanner = new Scanner(System.in);
        // response = scanner.nextLine();
        
        
        // switch (response) {
        //     case Commands.AUTH: app.authenticate.startAuth(); break;
        //     case Commands.AVA_CURR: app.availableCrypto.getAvailableCurrencies(); break;
        //     case Commands.SELECT_ITEM: app.selectItem.browseInvoiceURl(app.selectItem.getInvoiceUrl(app.testClassItems.items)); break;
        
        //     default:
        //         break;
        // }

        NOWPayment nowPayment = new NOWPayment.Builder()
            .email(System.getenv("NOW_E")+"@gmail.com")
            .password(System.getenv("NOW_P"))
            .build();


        // System.out.println(nowPayment.getAvailableCrypto());
        System.out.println(nowPayment.getToken());
        Invoice syna = new Invoice.Builder()
        .price_amount(15)
        .price_currency("usd")
        .order_description("Syna hat by Central Cee")
        .build();
        System.out.println(nowPayment.createInvoice(syna));

    }

}