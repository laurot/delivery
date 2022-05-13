package com.solvd.bin.orders;

import javax.xml.bind.annotation.*;

import com.solvd.bin.stores.Product;

@XmlRootElement(name = "deliveryProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryProducts {
    @XmlElement(name = "product")
    private Product product;
    @XmlElement(name = "amount")
    private int amount;

    public DeliveryProducts(){}
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
