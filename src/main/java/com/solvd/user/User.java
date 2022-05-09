package com.solvd.user;

import com.solvd.languages.Languages;
import com.solvd.location.Address;

public class User {
    private long id;
    private String name;
    private String email;
    private Languages language;
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
