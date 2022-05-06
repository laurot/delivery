package com.solvd.dao.jdbcMySQL;

import java.util.ArrayList;
import java.util.List;

import com.solvd.dao.IStoreDAO;
import com.solvd.location.City;
import com.solvd.stores.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.Properties;

public class StoreDAO implements IStoreDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");
    private AddressDAO addressDAO = new AddressDAO();

    @Override
    public Store getEntityById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveEntity(Store entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Store entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Store> getStoresByCity(City city) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM store WHERE id_city = ?");
            ps.setLong(1, city.getId());
            ResultSet rs = ps.executeQuery();
            List<Store> stores = new ArrayList<Store>();

            while(rs.next()){
                Store e = new Store(rs.getLong("id"),rs.getString("name"),
                                    addressDAO.getEntityById(rs.getLong("id_address")));
                stores.add(e);
            }
            return stores;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
