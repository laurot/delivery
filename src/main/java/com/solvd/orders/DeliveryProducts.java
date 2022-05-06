package com.solvd.orders;

import com.solvd.stores.Product;

public class DeliveryProducts {

    private Product product;
    private int amount;

    public DeliveryProducts(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
