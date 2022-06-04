package com.solvd.dao.mybatisDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.dao.IDeliveryProductsDAO;
import com.solvd.util.SessionGetter;

public class DeliveryProductsDAO implements IDeliveryProductsDAO{

    @Override
    public DeliveryProducts getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(DeliveryProducts entity) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IDeliveryProductsDAO driverDAO = session.getMapper(IDeliveryProductsDAO.class);
            driverDAO.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(DeliveryProducts entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void saveOrder(List<DeliveryProducts> order) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public List<DeliveryProducts> getOrderByDeliveryId(long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IDeliveryProductsDAO driverDAO = session.getMapper(IDeliveryProductsDAO.class);
            return driverDAO.getOrderByDeliveryId(id);
        }
    }


    
}
