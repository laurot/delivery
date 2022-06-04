package com.solvd.service.interfaces;

import com.solvd.bin.orders.Delivery;

public interface IDeliveryServices {
    public Delivery getDeliveryById(long id);
    public void saveOrder(Delivery order);
}
