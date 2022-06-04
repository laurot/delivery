package com.solvd.dao.mybatisDAO;

import org.apache.ibatis.session.SqlSession;

import com.solvd.bin.orders.Delivery;
import com.solvd.dao.IDeliveryDAO;
import com.solvd.util.SessionGetter;

public class DeliveryDAO implements IDeliveryDAO{

    @Override
    public Delivery getEntityById(long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IDeliveryDAO deliveryDAO = session.getMapper(IDeliveryDAO.class);
            return deliveryDAO.getEntityById(id);
        }
       
    }

    @Override
    public void saveEntity(Delivery entity) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IDeliveryDAO deliveryDAO = session.getMapper(IDeliveryDAO.class);
            deliveryDAO.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(Delivery entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }
    
}
