package com.solvd.dao.jdbcMySQL;

import java.sql.*;

import com.solvd.bin.orders.DeliveryProducts;

import java.util.ArrayList;
import java.util.List;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class DeliveryProductsDAO implements IDeliveryProductsDAO{
    
    private Logger LOGGER = LogManager.getLogger();
    private ProductDAO productDAO = new ProductDAO();
    
    @Override
    public DeliveryProducts getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(DeliveryProducts entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(DeliveryProducts entity) {
        throw new UnsupportedOperationException("This method shoould be implemented"); 
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");  
    }

    @Override
    public void saveOrder(List<DeliveryProducts> order) {
        order.stream().forEach((entity)-> {
            PreparedStatement ps = null;
            try(Connection con = DBCPDataSource.getConnection()){
                ps = con.prepareStatement("INSERT INTO deliveryproduct VALUES (?,?,?);");
                ps.setLong(1, entity.getDeliveryId());
                ps.setLong(2, entity.getProduct().getId());
                ps.setLong(3, entity.getAmount());
                ps.executeUpdate();
               
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
        });
    }

    @Override
    public List<DeliveryProducts> getOrderByDeliveryId(long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM deliveryproduct WHERE id_currentDelivery = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            List<DeliveryProducts> list = new ArrayList<DeliveryProducts>();
            while(rs.next()){
                DeliveryProducts c = new DeliveryProducts();
                c.setAmount(rs.getInt("amount"));
                c.setProduct(productDAO.getEntityById(rs.getLong("id_product")));
                list.add(c);
            }
            return list;
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

}
