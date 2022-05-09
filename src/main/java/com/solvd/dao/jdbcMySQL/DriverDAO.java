package com.solvd.dao.jdbcMySQL;

import com.solvd.dao.IDriverDAO;
import com.solvd.user.Driver;
import com.solvd.DBCPDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
public class DriverDAO implements IDriverDAO{

    private Logger LOGGER = LogManager.getLogger();

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
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT id,id_user,MAX(rating),free FROM driver WHERE free = 1 GROUP BY id");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Driver driver = new Driver();
                driver.setId(rs.getLong("id"));
                driver.setRating(rs.getInt("MAX(rating)"));
                driver.setUser(userDAO.getEntityById(rs.getLong("id_user")));
                driver.setFree(true);
                return driver;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
