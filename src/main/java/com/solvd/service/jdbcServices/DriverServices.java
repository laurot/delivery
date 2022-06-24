package com.solvd.service.jdbcServices;

import com.solvd.bin.user.Driver;
import com.solvd.dao.IDriverDAO;
import com.solvd.dao.jdbcMySQL.DriverDAO;
import com.solvd.service.IDriverServices;

public class DriverServices implements IDriverServices{

    private IDriverDAO driverDAO = new DriverDAO();
    @Override
    public Driver getFreeDriver() {
        return driverDAO.getFreeDriver();
    }
    
}
