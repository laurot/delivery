package com.solvd.service.daoServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.bin.orders.Delivery;
import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.dao.mybatisDAO.DeliveryDAO;
import com.solvd.dao.mybatisDAO.DeliveryProductsDAO;
import com.solvd.service.interfaces.IDeliveryServices;

public class DeliveryServices implements IDeliveryServices{

    private static final Logger Log = LogManager.getLogger();
    private IDeliveryDAO deliveryDAO = new DeliveryDAO();
    private IDeliveryProductsDAO deliveryProductsDAO = new DeliveryProductsDAO();

    @Override
    public Delivery getDeliveryById(long id) {
        return deliveryDAO.getEntityById(id);
    }

    @Override
    public void saveOrder(Delivery order) {
        deliveryDAO.saveEntity(order);
        List<DeliveryProducts> cart = order.getCart();
        for (DeliveryProducts item : cart) {
            item.setDeliveryId(order.getId());
            deliveryProductsDAO.saveEntity(item);
        }
        Log.info("The order has been made");
    }
    
}
