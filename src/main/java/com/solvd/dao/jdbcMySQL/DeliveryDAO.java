package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import com.solvd.DBCPDataSource;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.orders.Delivery;
import org.apache.logging.log4j.*;

public class DeliveryDAO implements IDeliveryDAO{

    private Logger LOGGER = LogManager.getLogger();
    private DeliveryProductsDAO deliveryProductsDAO = new DeliveryProductsDAO();
    
    @Override
    public Delivery getEntityById(long id) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}
