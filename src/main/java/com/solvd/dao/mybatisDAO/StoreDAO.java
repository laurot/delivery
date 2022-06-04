package com.solvd.dao.mybatisDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.bin.stores.Store;
import com.solvd.dao.IStoreDAO;
import com.solvd.util.SessionGetter;

public class StoreDAO implements IStoreDAO{

    @Override
    public Store getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(Store entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void updateEntity(Store entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public List<Store> getStoresByCityId(long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IStoreDAO storeDAO = session.getMapper(IStoreDAO.class);
            return storeDAO.getStoresByCityId(id);
        }
    }
    
}
