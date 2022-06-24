package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.solvd.bin.stores.Inventory;
import com.solvd.dao.IInventoryDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.*;

public class InventoryDAO implements IInventoryDAO{

    private Logger LOGGER = LogManager.getLogger();
    private ProductDAO productDAO = new ProductDAO();

    @Override
    public Inventory getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(Inventory entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(Inventory entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");  
    }

    @Override
    public List<Inventory> getInventoryByStoreId(Long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM inventory WHERE id_store = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            List<Inventory> stock = new ArrayList<Inventory>();

            while(rs.next()){
                Inventory e = new Inventory();
                e.setAmount(rs.getLong("amount"));
                e.setProduct(productDAO.getEntityById(rs.getLong("id_product")));
                stock.add(e);
            }
           
            return stock;
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
