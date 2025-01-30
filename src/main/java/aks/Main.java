package aks;

import aks.statics.Strings;
import aks.statics.Tickers;

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
            .key(Strings.API_KEY)
            .build();

        // System.out.println(nowPayment.validateAddress("0x4879fb6dF3850fb982699EfFd0BE6D3ed604E141", Tickers.USDT_BNB));
        // System.out.println(nowPayment.convertFiatToCrypto(15.53, "usd", Tickers.BITCOIN));
        
        Payment payment = new Payment.Builder()
            .price_amount(23.00)
            .price_currency("usd")
            .pay_currency("doge")
            .build();
        
        System.out.println(nowPayment.createPayment(payment));
    }

}