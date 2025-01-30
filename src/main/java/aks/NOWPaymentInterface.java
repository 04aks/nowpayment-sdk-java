package aks;

public interface NOWPaymentInterface {

    //get token (authenticate using Email and password)
    String authToken();
    
    // get checked currencies (currencies you accept payments with)
    String getAvailableCrypto();

    // Create an Invoice
    String createInvoice(Invoice invoice);

    // Check your balance (idk from where tbh)
    String checkBalance();

    // Check if recipient's wallet address is valid
    String validateAddress(String address, String ticker);

    // get estimated amount in crypto
    String convertFiatToCrypto(double amount, String from, String to);

    // create a payment
    String createPayment(Payment payment);
}
