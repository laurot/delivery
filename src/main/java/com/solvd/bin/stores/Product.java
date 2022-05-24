package com.solvd.bin.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Brand Brand;
    @JsonProperty
    private Double price;
    
    public Double getPrice() {
        return price;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Brand getBrand() {
        return Brand;
    }
    public void setBrand(Brand brand) {
        this.Brand = brand;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
