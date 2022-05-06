package com.solvd.dao.jdbcMySQL;

import com.solvd.dao.IBrandDAO;
import com.solvd.stores.Brand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.Properties;

public class BrandDAO implements IBrandDAO{
    
    private Logger LOGGER = LogManager.getLogger();
    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");

    @Override
    public Brand getEntityById(long id) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM brand WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            Brand b = new Brand();
            b.setId(id);
            b.setName(rs.getString("name"));
            return b;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Brand entity) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("INSERT INTO brand (name) VALUES (?);");
            ps.setString(1, entity.getName());
            ps.executeQuery();
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
    }

    @Override
    public void updateEntity(Brand entity) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("UPDATE brand SET name = "+ entity.getName()
                                                        + " WHERE id = ?;");
            ps.setString(1, entity.getName());
            ps.setLong(2, entity.getId());
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        
    }

    @Override
    public void deleteEntityById(long id) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("DELETE FROM brand WHERE id = ?;");
            ps.setLong(1,id);
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
    }
    
}
