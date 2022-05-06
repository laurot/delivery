package com.solvd.dao.jdbcMySQL;

import com.solvd.dao.ICountryDAO;
import com.solvd.location.Country;
import java.sql.*;
import java.util.Properties;
import org.apache.logging.log4j.*;

public class CountryDAO implements ICountryDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");
    
    @Override
    public Country getEntityById(long id) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM city WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            Country c = new Country();
            c.setId(id);
            c.setName(rs.getString("name"));
            c.setPriceMult(rs.getDouble("priceMultiplier"));
            return c;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Country entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Country entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}
