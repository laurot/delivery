package com.solvd.dao.jdbcMySQL;

import com.solvd.bin.stores.Brand;
import com.solvd.dao.IBrandDAO;
import com.solvd.util.DBCPDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class BrandDAO implements IBrandDAO{
    
    private Logger LOGGER = LogManager.getLogger();

    @Override
    public Brand getEntityById(long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("SELECT * FROM brand WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Brand b = new Brand();
                b.setId(id);
                b.setName(rs.getString("name"));
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
    public void saveEntity(Brand entity) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("INSERT INTO brand (name) VALUES (?);");
            ps.setString(1, entity.getName());
            ps.executeQuery();
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
    }

    @Override
    public void updateEntity(Brand entity) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("UPDATE brand SET name = "+ entity.getName()
                                                        + " WHERE id = ?;");
            ps.setString(1, entity.getName());
            ps.setLong(2, entity.getId());
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
        
    }

    @Override
    public void deleteEntityById(long id) {        
        PreparedStatement ps = null;
        try(Connection con = DBCPDataSource.getConnection()){ 
            ps = con.prepareStatement("DELETE FROM brand WHERE id = ?;");
            ps.setLong(1,id);
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
    }
    
}
