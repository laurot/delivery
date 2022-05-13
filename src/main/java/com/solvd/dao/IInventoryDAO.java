package com.solvd.dao;

import java.util.List;

import com.solvd.bin.stores.Inventory;
import com.solvd.bin.stores.Store;

public interface IInventoryDAO extends IBaseDAO<Inventory>{
    List<Inventory> getInventoryByStore(Store store);
}
