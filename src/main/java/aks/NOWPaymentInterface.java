package aks;

public interface NOWPaymentInterface {

    //get token (authenticate using Email and password)
    String authToken();
    
    // get checked currencies (currencies you accept payments with)
    String getAvailableCrypto();

    // Create an Invoice
    String createInvoice(Invoice invoice);
}
