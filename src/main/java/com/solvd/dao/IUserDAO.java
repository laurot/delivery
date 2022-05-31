package com.solvd.dao;

import java.util.List;

import com.solvd.bin.Languages;
import com.solvd.bin.user.User;

public interface IUserDAO extends IBaseDAO<User>{
    List<User> getUsersByLanguage(Languages l);
    User getUserByUsername(String username);
    boolean authenticate(User user, String pass);
}
