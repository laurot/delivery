package com.solvd.stores;

import com.solvd.location.Address;

public class Store {
    private long id;
    private String name;
    private Address address;
    
    public Store(long id, String name, Address address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public long getId() {
        return id;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }
    
}
