package com.solvd.bin.user;

import javax.xml.bind.annotation.*;

import com.solvd.bin.languages.Languages;
import com.solvd.bin.location.Address;
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "language")
    private Languages language;
    @XmlElement(name = "address")
    private Address address;

    public User(){}
    public User (String name,String pass, String email, Languages language){
        this.name = name;
        this.email = email;
        this.language = language;
    }
    public boolean exists(){
        if (id != 0L)return true;
        return false;
    }    
    public long getId() {
        return id;
    }
    public Languages getLanguage() {
        return language;
    }
    public void setLanguage(Languages language) {
        this.language = language;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
