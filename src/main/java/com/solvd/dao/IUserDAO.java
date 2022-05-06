package com.solvd.dao;

import java.util.List;
import com.solvd.languages.Language;
import com.solvd.user.User;

public interface IUserDAO extends IBaseDAO<User>{
    List<User> getUsersByLanguage(Language l);
    User getUserByUsername(String username);
}
