package com.solvd.dao.jdbcMySQL;

import java.sql.*;
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
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
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
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error("Error in SQL", e);
                }
            }
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
    public User getUserByUsername(String user) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM user WHERE username = ?");
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();
           
            if(rs.next()){
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("username"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setLanguage(languageDAO.getEntityById(rs.getLong("id_language")));
                u.setAddress(addressDAO.getEntityById(rs.getLong("id_address")));
                return u;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error("Error in SQL", e);
                }
            }
        }
        return null;
    }
}
