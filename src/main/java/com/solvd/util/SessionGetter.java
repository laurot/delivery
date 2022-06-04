package com.solvd.util;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.*;

public class SessionGetter {
    
    private static final Logger Log = LogManager.getLogger();
    private static final SessionGetter instance = new SessionGetter();
    private SqlSession session;

    private SessionGetter(){}

    public static SessionGetter getInstance(){
        return instance;
    }
    
    public SqlSession getSession(){
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory s = new SqlSessionFactoryBuilder().build(r);
            session = s.openSession();
        } catch (IOException e) {
            Log.error(e.getMessage());
        }
        return session;
    }
}
