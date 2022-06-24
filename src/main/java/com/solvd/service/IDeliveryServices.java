package com.solvd.service;

import com.solvd.bin.orders.Delivery;

public interface IDeliveryServices {
    public Delivery getDeliveryById(long id);
    public void saveOrder(Delivery order);
}
