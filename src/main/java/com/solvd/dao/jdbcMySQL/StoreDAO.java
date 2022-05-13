package com.solvd.dao.jdbcMySQL;

import java.util.ArrayList;
import java.util.List;
import com.solvd.bin.location.City;
import com.solvd.bin.stores.Store;
import com.solvd.dao.IStoreDAO;
import com.solvd.util.DBCPDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class StoreDAO implements IStoreDAO{

    private Logger LOGGER = LogManager.getLogger();
    private UserDAO userDAO = new UserDAO();
    private AddressDAO addressDAO = new AddressDAO();

    @Override
    public Store getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(Store entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(Store entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public List<Store> getStoresByCity(City city) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                "SELECT s.* FROM store s join address a on a.id = s.id_address WHERE a.id_city = ?");
            ps.setLong(1, city.getId());
            ResultSet rs = ps.executeQuery();
            List<Store> stores = new ArrayList<Store>();
            while(rs.next()){
                Store e = new Store(rs.getLong("id"),rs.getString("name"),
                                    addressDAO.getEntityById(rs.getLong("id_address")),
                                    userDAO.getEntityById(rs.getLong("id_user")));
                stores.add(e);
            }
            return stores;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
