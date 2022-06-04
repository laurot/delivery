package com.solvd.service.daoServices;

import com.solvd.bin.user.Driver;
import com.solvd.dao.IDriverDAO;
import com.solvd.dao.mybatisDAO.DriverDAO;
import com.solvd.service.interfaces.IDriverServices;

public class DriverServices implements IDriverServices{
    
    private IDriverDAO driverDAO = new DriverDAO();
    
    @Override
    public Driver getFreeDriver() {
        return driverDAO.getFreeDriver();
    }
    
}
