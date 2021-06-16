package com.bjpowernode.InvactionHandler;

import com.bjpowernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.net.ssl.SSLSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @2021/6/13 @16:49
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        Object result = null;
        SqlSession sqlSession = null;
        System.out.println("------调用目标方法前------");
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            result = method.invoke(target,args);
            sqlSession.commit();
        } catch (IllegalAccessException | InvocationTargetException e) {
            sqlSession.rollback();
            sqlSession.close();
            e.printStackTrace();
        }

        System.out.println("------调用目标方法后------");
        return result;
    }
}
