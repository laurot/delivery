package com.solvd.dao;

import com.solvd.bin.user.Driver;

public interface IDriverDAO extends IBaseDAO<Driver>{
    
    Driver getFreeDriver();
}
