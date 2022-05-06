package com.solvd.dao;

import java.util.List;
import com.solvd.location.City;
import com.solvd.stores.Store;

public interface IStoreDAO extends IBaseDAO<Store> {
    
    List<Store> getStoresByCity(City city);
}
