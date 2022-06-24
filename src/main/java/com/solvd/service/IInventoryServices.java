package com.solvd.service;

import java.util.List;
import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.bin.stores.Store;

public interface IInventoryServices {
    
    public List<DeliveryProducts> getCart(Store store);
}
