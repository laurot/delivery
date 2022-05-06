package com.solvd.user;

public class Vehicle {
    private long id;
    private Driver driver;
    private String type;
    private String plate;
    
    public String getPlate() {
        return plate;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
}
