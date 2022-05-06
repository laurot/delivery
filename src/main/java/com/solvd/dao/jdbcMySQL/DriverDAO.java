package com.solvd.dao.jdbcMySQL;

import com.solvd.dao.IDriverDAO;
import com.solvd.user.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.Properties;
public class DriverDAO implements IDriverDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");
    private UserDAO userDAO = new UserDAO();

    @Override
    public Driver getEntityById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveEntity(Driver entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Driver entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Driver getFreeDriver() {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT MAX(rating) FROM driver WHERE free = 1");
            ResultSet rs = ps.executeQuery();
            Driver driver = new Driver();
            driver.setId(rs.getLong("id"));
            driver.setRating(rs.getInt("rating"));
            driver.setUser(userDAO.getEntityById(rs.getLong("id_user")));
            driver.setFree(true);
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
