package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.Properties;
import com.solvd.dao.IAddressDAO;
import com.solvd.location.Address;
import org.apache.logging.log4j.*;

public class AddressDAO implements IAddressDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");
    private CityDAO cityDAO = new CityDAO();
    
    @Override
    public Address getEntityById(long id) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM address WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            Address b = new Address();
            b.setId(id);
            b.setAddress(rs.getString("address"));
            b.setCity(cityDAO.getEntityById(rs.getLong("id")));
            return b;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Address entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Address entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}
