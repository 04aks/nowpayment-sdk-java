package aks;

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
            .email("bruuuh")
            .password("bruuuh")
            .build();


        // System.out.println(nowPayment.getAvailableCrypto());
        System.out.println(nowPayment.getToken());

    }

}