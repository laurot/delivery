package com.solvd.dao.jdbcMySQL;

import java.sql.*;

import com.solvd.bin.location.Address;
import com.solvd.dao.IAddressDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class AddressDAO implements IAddressDAO{

    private Logger LOGGER = LogManager.getLogger();
    private CityDAO cityDAO = new CityDAO();
    
    @Override
    public Address getEntityById(long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM address WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Address b = new Address();
                b.setId(id);
                b.setAddress(rs.getString("address"));
                b.setCity(cityDAO.getEntityById(rs.getLong("id_city")));
                return b;
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
    public void saveEntity(Address entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");  
    }

    @Override
    public void updateEntity(Address entity) {
        throw new UnsupportedOperationException("This method shoould be implemented"); 
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented"); 
    }
    
}
