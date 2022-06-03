package com.solvd.bin.location;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "city")
    private City city;
    
    public Address(){}
    public Address(String address){
        this.address = address;
        this.city = new City(1);
    }
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
