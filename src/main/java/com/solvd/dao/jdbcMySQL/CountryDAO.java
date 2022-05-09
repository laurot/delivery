package com.solvd.dao.jdbcMySQL;

import com.solvd.DBCPDataSource;
import com.solvd.dao.ICountryDAO;
import com.solvd.location.Country;
import java.sql.*;
import org.apache.logging.log4j.*;

public class CountryDAO implements ICountryDAO{

    private Logger LOGGER = LogManager.getLogger();
    
    @Override
    public Country getEntityById(long id) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM country WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Country c = new Country();
                c.setId(id);
                c.setName(rs.getString("name"));
                c.setPriceMult(rs.getDouble("priceMultiplier"));
                return c;
            }
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
