package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import com.solvd.DBCPDataSource;
import java.util.List;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.orders.DeliveryProducts;
import org.apache.logging.log4j.*;

public class DeliveryProductsDAO implements IDeliveryProductsDAO{
    
    private Logger LOGGER = LogManager.getLogger();

    
    @Override
    public DeliveryProducts getEntityById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveEntity(DeliveryProducts entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(DeliveryProducts entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveOrder(List<DeliveryProducts> order, long idDelivery) {
        order.stream().forEach((entity)-> {
            try(Connection con = DBCPDataSource.getConnection()){
                PreparedStatement ps = con.prepareStatement("INSERT INTO deliveryproduct VALUES (?,?,?);");
                ps.setLong(1, idDelivery);
                ps.setLong(2, entity.getProduct().getId());
                ps.setLong(3, entity.getAmount());
                ps.executeUpdate();
            }catch(SQLException se){
                LOGGER.warn(se.getMessage());
            }
        });
        
    }

}
