package aks.goods;

import java.util.HashMap;

public class TestClassItems {
    
    private Item coldWallet = new Item(32, "usd", "Crypto Cold wallet, usb stick");
    private Item shoes = new Item(47, "usd", "Shoes white");
    private Item chain = new Item(24, "usd", "broke people chain");
    private Item card = new Item(8, "usd", "Fake Amex Card");
    public HashMap<Integer, Item> items = new HashMap<>();

    public TestClassItems(){
        
        items.put(1, coldWallet);
        items.put(2, shoes);
        items.put(3, chain);
        items.put(4, card);
    }

    public HashMap<Integer, Item> getItems() {
        return items;
    }
}
