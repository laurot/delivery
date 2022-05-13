package com.solvd.bin.stores;

public class Inventory {
    private Store store;
    private Product product;
    private long amount;
    
    public long getAmount() {
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
    public void setAmount(long amount) {
        this.amount = amount;
    }
}
