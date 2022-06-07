package com.solvd.service.daoServices;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.bin.orders.Delivery;
import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.service.interfaces.IDeliveryServices;

public class DeliveryServices extends Services implements IDeliveryServices{

    private static final Logger Log = LogManager.getLogger();

    @Override
    public Delivery getDeliveryById(long id) {
        try (SqlSession session = getSession()) {
            IDeliveryDAO deliveryDAO = session.getMapper(IDeliveryDAO.class);
            return deliveryDAO.getEntityById(id);
        }
    }

    @Override
    public void saveOrder(Delivery order) {
        try (SqlSession session = getSession()) {
            IDeliveryDAO deliveryDAO = session.getMapper(IDeliveryDAO.class);
            IDeliveryProductsDAO deliveryProductsDAO = session.getMapper(IDeliveryProductsDAO.class);
            deliveryDAO.saveEntity(order);
            List<DeliveryProducts> cart = order.getCart();
            for (DeliveryProducts item : cart) {
                item.setDeliveryId(order.getId());
                deliveryProductsDAO.saveEntity(item);
            }
            Log.info("The order has been made");
        }
    }
    
}
