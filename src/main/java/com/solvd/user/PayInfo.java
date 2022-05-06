package com.solvd.user;

public class PayInfo {
    private long id;
    private User user;
    private String cardNumber;
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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
}
