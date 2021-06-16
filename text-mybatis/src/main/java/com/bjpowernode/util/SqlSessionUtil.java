package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

/**
 * @author Administrator
 * @2021/6/13 @17:35
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static{
        try {
            String config = "conf/mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        if (threadLocal.get()==null){
            threadLocal.set(sqlSessionFactory.openSession());
        }
        return threadLocal.get();
    }

    public static void SqlSessionClose(){
        if (threadLocal.get() != null) {
            threadLocal.get().close();
            threadLocal.remove();
        }
    }
}
