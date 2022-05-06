package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import com.solvd.dao.IUserDAO;
import com.solvd.languages.Language;
import com.solvd.user.User;

public class UserDAO implements IUserDAO{

    private Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String pass = p.getProperty("db.pass");

    @Override
    public User getEntityById(long id) {

        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("username"));
            u.setEmail(rs.getString(rs.getString("email")));
            return u;
        }catch(SQLException s){

        }
        return null;
    }

    @Override
    public void saveEntity(User entity) {

    }

    @Override
    public void updateEntity(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<User> getUsersByLanguage(Language l) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        try(Connection con = DriverManager.getConnection(url,username,pass)){
            PreparedStatement ps = con.prepareStatement("SELECT FROM user WHERE username = ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setPass(rs.getString("pass"));
            return u;
        }catch(SQLException s){

        }
        return null;
    }
    
}
