package com.solvd.service.myBatis;

import org.apache.ibatis.session.SqlSession;

import com.solvd.util.SessionGetter;

public abstract class Services {
    
    protected SqlSession getSession(){
        return SessionGetter.getInstance().getSession();
    }
}
