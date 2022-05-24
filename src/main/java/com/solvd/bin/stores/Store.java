package com.solvd.bin.stores;

import javax.xml.bind.annotation.*;

import com.solvd.bin.location.Address;

@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "address")
    private Address address;
    
    public Store(){}

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
