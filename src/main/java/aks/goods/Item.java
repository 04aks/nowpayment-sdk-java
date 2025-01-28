package aks.goods;

public class Item {
    
    private double price_amount;
    private String price_currency;
    private String order_description;

    public Item(double price_amount, String price_currency, String order_description){
        this.price_amount = price_amount;
        this.price_currency = price_currency;
        this.order_description = order_description;
    }


    public double getPrice_amount() {
        return price_amount;
    }
    public String getPrice_currency() {
        return price_currency;
    }
    public String getOrder_description() {
        return order_description;
    }



    public void setPrice_amount(double price_amount) {
        this.price_amount = price_amount;
    }
    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }
    public void setOrder_description(String order_description) {
        this.order_description = order_description;
    }
}
