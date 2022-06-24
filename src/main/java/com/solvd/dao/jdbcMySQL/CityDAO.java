package com.solvd.dao.jdbcMySQL;

import java.sql.*;

import com.solvd.bin.location.City;
import com.solvd.dao.ICityDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class CityDAO implements ICityDAO{

    private Logger LOGGER = LogManager.getLogger();
    private CountryDAO countryDAO = new CountryDAO();

    @Override
    public City getEntityById(long id) {        PreparedStatement ps = null;
try(Connection con = DBCPDataSource.getConnection()){ ps = con.prepareStatement("SELECT * FROM city WHERE id = ?");
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
        throw new UnsupportedOperationException("This method shoould be implemented");    
    }

    @Override
    public void updateEntity(City entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");   
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");   
    }
    
}
