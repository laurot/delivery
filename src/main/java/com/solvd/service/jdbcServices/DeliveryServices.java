package com.solvd.service.jdbcServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bin.orders.Delivery;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.dao.jdbcMySQL.DeliveryDAO;
import com.solvd.dao.jdbcMySQL.DeliveryProductsDAO;
import com.solvd.service.interfaces.IDeliveryServices;

public class DeliveryServices implements IDeliveryServices{

    private static final Logger Log = LogManager.getLogger();
    private IDeliveryDAO deliveryDAO = new DeliveryDAO();
    private IDeliveryProductsDAO deliveryProductsDAO = new DeliveryProductsDAO();
    
    @Override
    public Delivery getDeliveryById(long id) {
        Delivery delivery = deliveryDAO.getEntityById(id);
        delivery.setCart(deliveryProductsDAO.getOrderByDeliveryId(delivery.getId()));
        return delivery;
    }

    @Override
    public void saveOrder(Delivery order) {
        deliveryDAO.saveEntity(order);
        Log.info("The order has been made");
    }
    
}
