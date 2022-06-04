package com.solvd.dao.mybatisDAO;

import java.util.List;
import com.solvd.bin.Languages;
import com.solvd.dao.ILanguageDAO;
import com.solvd.util.SessionGetter;

import org.apache.ibatis.session.SqlSession;

public class LanguageDAO implements ILanguageDAO{

    @Override
    public Languages getEntityById(long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
        ILanguageDAO languageDAO = session.getMapper(ILanguageDAO.class);
        return languageDAO.getEntityById(id);
        }
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
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
        ILanguageDAO languageDAO = session.getMapper(ILanguageDAO.class);
        return languageDAO.getLanguages();
        }
    }
    
}
