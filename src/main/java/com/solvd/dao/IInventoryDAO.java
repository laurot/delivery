package com.solvd.dao;

import java.util.List;
import com.solvd.stores.Inventory;
import com.solvd.stores.Store;

public interface IInventoryDAO extends IBaseDAO<Inventory>{
    List<Inventory> getInventoryByStore(Store store);
}
