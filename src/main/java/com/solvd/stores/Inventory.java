package com.solvd.stores;

public class Inventory {
    private Store store;
    private Product product;
    private int amount;
    
    public int getAmount() {
        return amount;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
