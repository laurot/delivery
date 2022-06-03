package com.solvd.bin.location;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "priceMult")
    private Double priceMult;
    public Country(){}
    public Country(long id){
        this.id = id;
    }
    public Double getPriceMult() {
        return priceMult;
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
    public void setPriceMult(Double priceMult) {
        this.priceMult = priceMult;
    }
}
