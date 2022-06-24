package com.solvd.service;

import com.solvd.bin.user.User;

public interface IUserServices {
    
    public void userLogin();
    public void createUser();
    public void updateUser(User user);
    public void makeOrder(User user);
    public void uMenu(User user);
}
