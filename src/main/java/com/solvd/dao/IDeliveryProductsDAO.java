package com.solvd.dao;

import java.util.List;

import com.solvd.bin.orders.DeliveryProducts;

public interface IDeliveryProductsDAO extends IBaseDAO<DeliveryProducts>{
    void saveOrder(List<DeliveryProducts> order, long idDelivery);
    List<DeliveryProducts> getOrderByDeliveryId(long id);
}
