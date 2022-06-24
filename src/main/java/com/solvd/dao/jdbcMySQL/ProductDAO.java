package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import com.solvd.dao.IBrandDAO;
import com.solvd.dao.IProductDAO;
import com.solvd.util.DBCPDataSource;
import com.solvd.bin.stores.Product;

import org.apache.logging.log4j.*;

public class ProductDAO implements IProductDAO{

    private Logger LOGGER = LogManager.getLogger();

    private IBrandDAO brandDAO = new BrandDAO();

    @Override
    public Product getEntityById(long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM product WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
           
            if(rs.next()){
                Product b = new Product();
                b.setId(id);
                b.setName(rs.getString("name"));
                b.setBrand(brandDAO.getEntityById(rs.getLong("id_brand")));
                b.setPrice(rs.getDouble("price"));
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
    public void saveEntity(Product entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(Product entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }
    
}
