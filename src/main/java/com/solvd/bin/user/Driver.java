package com.solvd.bin.user;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "driver")
@XmlAccessorType(XmlAccessType.FIELD)
public class Driver{
    @XmlAttribute(name="id")
    private long id;
    @XmlElement(name = "rating")
    private int rating;
    @XmlElement(name = "free")
    private boolean free;
    @XmlElement(name = "user")
    private User user;
    
    public int getRating() {
        return rating;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
}
