package com.solvd.bin.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inventory {
    @JsonProperty
    private Product product;
    @JsonProperty
    private long amount;
    
    public long getAmount() {
        return amount;
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
