package com.solvd.bin;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "language")
@XmlAccessorType(XmlAccessType.FIELD)
public class Languages {
    @XmlAttribute(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
