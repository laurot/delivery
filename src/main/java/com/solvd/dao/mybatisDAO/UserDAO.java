package com.solvd.dao.mybatisDAO;

import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.util.SessionGetter;

import org.apache.ibatis.session.SqlSession;

public class UserDAO implements IUserDAO{

    @Override
    public User getEntityById(long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            return userDAO.getEntityById(id);
        }
    }

    @Override
    public void saveEntity(User entity) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(User entity) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.updateEntity(entity);
            session.commit();
        }
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public User getUserByUsername(String username) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            return userDAO.getUserByUsername(username);
        }
    } 
}
