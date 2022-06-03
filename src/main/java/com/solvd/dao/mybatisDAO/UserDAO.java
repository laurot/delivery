package com.solvd.dao.mybatisDAO;

import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.util.SessionGetter;

public class UserDAO implements IUserDAO{

    @Override
    public User getEntityById(long id) {
        IUserDAO userDAO = SessionGetter.getInstance().getSession().getMapper(IUserDAO.class);
        User user = userDAO.getEntityById(id);
        return user;
    }

    @Override
    public void saveEntity(User entity) {
        IUserDAO userDAO = SessionGetter.getInstance().getSession().getMapper(IUserDAO.class);
        userDAO.saveEntity(entity);
        SessionGetter.getInstance().getSession().commit();
    }

    @Override
    public void updateEntity(User entity) {
        IUserDAO userDAO = SessionGetter.getInstance().getSession().getMapper(IUserDAO.class);
        userDAO.updateEntity(entity);
        SessionGetter.getInstance().getSession().commit();
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public User getUserByUsername(String username) {
        IUserDAO userDAO = SessionGetter.getInstance().getSession().getMapper(IUserDAO.class);
        User user = userDAO.getUserByUsername(username);
        return user;
    } 
}
