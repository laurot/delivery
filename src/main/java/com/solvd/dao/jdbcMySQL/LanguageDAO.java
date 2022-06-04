package com.solvd.dao.jdbcMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.solvd.bin.Languages;
import com.solvd.dao.ILanguageDAO;
import com.solvd.util.DBCPDataSource;

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
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(Languages entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public List<Languages> getLanguages() {
        try(Connection con = DBCPDataSource.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM language");
            ResultSet rs = ps.executeQuery();
            List<Languages> languages = new ArrayList<Languages>();
            while(rs.next()){
                Languages u = new Languages();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                languages.add(u);
            }
            return languages;
        }catch(SQLException se){
            LOGGER.warn(se.getMessage());
        }
        return null;
    }
    
}
