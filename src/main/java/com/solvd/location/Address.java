package com.solvd.location;

public class Address {
    private long id;
    private String address;
    private City city;
    
    public City getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
