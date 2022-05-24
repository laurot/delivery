package com.solvd.bin.orders;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.bin.stores.Store;
import com.solvd.bin.user.Driver;
import com.solvd.bin.user.User;
import com.solvd.util.xmlAdapter.DateAdapter;

@XmlRootElement(name="delivery")
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivery {

    @XmlAttribute (name="id")
    private long id;

    @XmlElement(name = "dateTime") 
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateTime;

    @XmlElement (name = "driver")
    private Driver driver;

    @XmlElement (name = "store")
    private Store store;

    @XmlElement (name = "user")
    private User user;

    @XmlElementWrapper(name = "cart")
    @XmlElement(name = "deliveryProducts")
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
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }

}
