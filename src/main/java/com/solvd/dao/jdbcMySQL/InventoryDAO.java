package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.solvd.dao.IInventoryDAO;
import com.solvd.stores.Inventory;
import com.solvd.stores.Store;
import org.apache.logging.log4j.*;

public class InventoryDAO implements IInventoryDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");

    @Override
    public Inventory getEntityById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveEntity(Inventory entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Inventory entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Inventory> getInventoryByStore(Store store) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM store WHERE id_store = ?");
            ps.setLong(1, store.getId());
            ResultSet rs = ps.executeQuery();
            List<Inventory> stock = new ArrayList<Inventory>();

            while(rs.next()){
                Inventory e = new Inventory();
                e.setAmount(rs.getInt("amount"));
                e.setProduct(null);
                e.setStore(store);
                stock.add(e);
            }
            return stock;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
