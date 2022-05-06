package com.solvd.location;

public class Country {
    private long id;
    private String name;
    private Double priceMult;

    public Double getPriceMult() {
        return priceMult;
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
    public void setPriceMult(Double priceMult) {
        this.priceMult = priceMult;
    }
}
