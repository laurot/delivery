package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.Properties;

import com.solvd.dao.IBrandDAO;
import com.solvd.dao.IProductDAO;
import com.solvd.stores.Product;
import org.apache.logging.log4j.*;

public class ProductDAO implements IProductDAO{

    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");
    private IBrandDAO brandDAO = new BrandDAO();

    @Override
    public Product getEntityById(long id) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            Product b = new Product();
            b.setId(id);
            b.setName(rs.getString("name"));
            b.setBrand(brandDAO.getEntityById(rs.getLong("id_brand")));
            b.setPrice(rs.getDouble("price"));
            return b;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Product entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Product entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}