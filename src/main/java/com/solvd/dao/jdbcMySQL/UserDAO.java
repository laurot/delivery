package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.List;

import com.solvd.bin.languages.Languages;
import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class UserDAO implements IUserDAO{

    private Logger LOGGER = LogManager.getLogger();
    private LanguageDAO languageDAO = new LanguageDAO();
    private AddressDAO addressDAO = new AddressDAO();

    @Override
    public User getEntityById(long id) {

        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setLanguage(languageDAO.getEntityById(rs.getLong("id_language")));
                u.setAddress(addressDAO.getEntityById(rs.getLong("id_address")));
                return u;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(User entity) {

    }

    @Override
    public void updateEntity(User entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public List<User> getUsersByLanguage(Languages l) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public User getUserByUsername(String user) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username = ?");
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setLanguage(languageDAO.getEntityById(rs.getLong("id_language")));
                u.setAddress(addressDAO.getEntityById(rs.getLong("id_address")));
                return u;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public boolean authenticate(User user, String pass) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT pass FROM user WHERE id = ?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(pass.equals(rs.getString("pass"))) return true;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return false;
    }
    
    
}
