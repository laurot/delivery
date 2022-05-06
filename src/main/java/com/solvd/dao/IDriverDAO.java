package com.solvd.dao;

import com.solvd.user.Driver;

public interface IDriverDAO extends IBaseDAO<Driver>{
    
    Driver getFreeDriver();
}
