package com.solvd.user;

public class License {
    private long id;
    private Driver driver;
    private long number;
    
    public long getNumber() {
        return number;
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
    public void setNumber(long number) {
        this.number = number;
    }

}
