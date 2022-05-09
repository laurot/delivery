package com.solvd.stores;

import com.solvd.location.Address;
import com.solvd.user.User;

public class Store {
    private long id;
    private String name;
    private Address address;
    private User user;
    
    public Store(long id, String name, Address address, User user){
        this.id = id;
        this.name = name;
        this.address = address;
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
