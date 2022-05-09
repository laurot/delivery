package com.solvd.dao.jdbcMySQL;

import com.solvd.DBCPDataSource;
import com.solvd.languages.Languages;
import java.sql.*;
import com.solvd.dao.ILanguageDAO;
import org.apache.logging.log4j.*;

public class LanguageDAO implements ILanguageDAO{

    private Logger LOGGER = LogManager.getLogger();
    
    @Override
    public Languages getEntityById(long id) {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM language WHERE id = ?");
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Languages u = new Languages();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }

    @Override
    public void saveEntity(Languages entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEntity(Languages entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEntityById(long id) {
        // TODO Auto-generated method stub
        
    }
    
}
