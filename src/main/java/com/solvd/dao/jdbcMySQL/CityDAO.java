package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import com.solvd.DBCPDataSource;
import com.solvd.dao.ICityDAO;
import com.solvd.location.City;
import org.apache.logging.log4j.*;

public class CityDAO implements ICityDAO{

    private Logger LOGGER = LogManager.getLogger();
    private CountryDAO countryDAO = new CountryDAO();

    @Override
    public City getEntityById(long id) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM city WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                City c = new City();
                c.setId(id);
                c.setName(rs.getString("name"));
                c.setCountry(countryDAO.getEntityById(rs.getInt("id_country")));
                return c;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(City entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(City entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}
