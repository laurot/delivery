package com.solvd.dao;

import java.util.List;

import com.solvd.bin.stores.Inventory;

public interface IInventoryDAO extends IBaseDAO<Inventory>{
    List<Inventory> getInventoryByStoreId(Long id);
}
