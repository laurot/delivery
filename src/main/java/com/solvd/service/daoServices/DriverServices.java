package com.solvd.service.daoServices;

import org.apache.ibatis.session.SqlSession;

import com.solvd.bin.user.Driver;
import com.solvd.dao.IDriverDAO;
import com.solvd.service.interfaces.IDriverServices;

public class DriverServices extends Services implements IDriverServices{
    
    @Override
    public Driver getFreeDriver() {
        try (SqlSession session = getSession()) {
            IDriverDAO driverDAO = session.getMapper(IDriverDAO.class);
            return driverDAO.getFreeDriver();
        }
    }
    
}
