package com.solvd.dao.mybatisDAO;

import com.solvd.bin.user.Driver;
import com.solvd.dao.IDriverDAO;
import com.solvd.util.SessionGetter;

import org.apache.ibatis.session.SqlSession;

public class DriverDAO implements IDriverDAO{

    @Override
    public Driver getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(Driver entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void updateEntity(Driver entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public Driver getFreeDriver() {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IDriverDAO driverDAO = session.getMapper(IDriverDAO.class);
            return driverDAO.getFreeDriver();
        }
    }
    
}
