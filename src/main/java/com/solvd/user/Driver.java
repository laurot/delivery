package com.solvd.user;

public class Driver{
    private long id;
    private User user;
    private int rating;
    private boolean free;
    
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
