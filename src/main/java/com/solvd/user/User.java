package com.solvd.user;

import com.solvd.languages.Language;
import com.solvd.location.Address;

public class User {
    private long id;
    private String name;
    private String email;
    private String pass;
    private Language language;
    private Address address;

    public User(){}
    public User (String name,String pass, String email, Language language){
        this.name = name;
        this.email = email;
        this.language = language;
        this.setPass(pass);
    }
    public boolean exists(){
        if (id != 0L)return true;
        return false;
    }    
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Boolean authenticate(String pass){
        return(pass.equals(this.pass));
    }
    public long getId() {
        return id;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
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
