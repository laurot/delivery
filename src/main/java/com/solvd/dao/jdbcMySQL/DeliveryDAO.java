package com.solvd.dao.jdbcMySQL;

import java.sql.*;

import com.solvd.bin.orders.Delivery;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class DeliveryDAO implements IDeliveryDAO{

    private Logger LOGGER = LogManager.getLogger();
    private DeliveryProductsDAO deliveryProductsDAO = new DeliveryProductsDAO();
    private UserDAO userDAO = new UserDAO();
    private DriverDAO driverDAO = new DriverDAO();
    private StoreDAO storeDAO = new StoreDAO();

    @Override
    public Delivery getEntityById(long id) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM delivery WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
           
            if(rs.next()){
                Delivery c = new Delivery();
                c.setId(id);
                c.setUser(userDAO.getEntityById(rs.getLong("id_user")));
                c.setDriver(driverDAO.getEntityById(rs.getLong("id_driver")));
                c.setStore(storeDAO.getEntityById(rs.getLong("id_store")));
                c.setDateTime(rs.getDate("timeCreated"));
                c.setCart(deliveryProductsDAO.getOrderByDeliveryId(rs.getLong("id")));

                return c;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Delivery entity) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO delivery (id_driver, id_store, id_user) VALUES (?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, entity.getDriver().getId());
            ps.setLong(2, entity.getStore().getId());
            ps.setLong(3, entity.getUser().getId());
            int affectedRows = ps.executeUpdate();
           
            if(affectedRows == 0) throw new SQLException("Saving delivery failed");
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                deliveryProductsDAO.saveOrder(entity.getCart(), generatedKeys.getLong(1));
            }
        }catch(SQLException  se){
            LOGGER.warn(se.getMessage());
        }
        
    }

    @Override
    public void updateEntity(Delivery entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");  
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");  
    }
    
}
