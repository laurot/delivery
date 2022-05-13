package com.solvd.dao;

import java.util.List;

import com.solvd.bin.location.City;
import com.solvd.bin.stores.Store;

public interface IStoreDAO extends IBaseDAO<Store> {
    
    List<Store> getStoresByCity(City city);
}
