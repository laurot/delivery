package com.solvd.dao.mybatisDAO;

import java.util.List;

import com.solvd.bin.location.City;
import com.solvd.bin.stores.Store;
import com.solvd.dao.IStoreDAO;

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
    public List<Store> getStoresByCity(City city) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }
    
}
