package com.solvd.bin.user;


public class PayInfo {
    private long id;
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
