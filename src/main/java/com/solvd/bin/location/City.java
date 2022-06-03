package com.solvd.bin.location;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "country")
    private Country country;
    public City(){}
    public City(int id){
        this.id = id;
        this.country = new Country(1);
    }
    public Country getCountry() {
        return country;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
}
