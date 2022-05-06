package com.solvd.orders;

import java.util.Date;
import java.util.List;
import com.solvd.location.Address;
import com.solvd.stores.Store;
import com.solvd.user.Driver;
import com.solvd.user.User;

public class Delivery {
    private long id;
    private Driver driver;
    private Address destination;
    private Store store;
    private User user;
    private Date dateTime;
    private List<DeliveryProducts> cart;
    
    public Date getDateTime() {
        return dateTime;
    }
    public List<DeliveryProducts> getCart() {
        return cart;
    }
    public void setCart(List<DeliveryProducts> cart) {
        this.cart = cart;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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
    public void setId(long id) {
        this.id = id;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Address getDestination() {
        return destination;
    }
    public void setDestination(Address destination) {
        this.destination = destination;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

}
