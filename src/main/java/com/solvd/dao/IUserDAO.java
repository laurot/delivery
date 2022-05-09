package com.solvd.dao;

import java.util.List;
import com.solvd.languages.Languages;
import com.solvd.user.User;

public interface IUserDAO extends IBaseDAO<User>{
    List<User> getUsersByLanguage(Languages l);
    User getUserByUsername(String username);
    boolean authenticate(User user, String pass);
}
