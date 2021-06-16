package com.bjpowernode;

import com.bjpowernode.Dao.StudentDao;
import com.bjpowernode.InvactionHandler.MyInvocationHandler;
import com.bjpowernode.Service.StudentService;
import com.bjpowernode.Service.impl.StudentServiceImpl;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author Administrator
 * @2021/6/13 @18:54
 */

public class test {
    @Test
    public void test01(){

        StudentService studentService = new StudentServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(studentService);
        StudentService proxy = (StudentService) Proxy.newProxyInstance(studentService.getClass().getClassLoader(),studentService.getClass().getInterfaces(),invocationHandler);
        /*List<Student> sList = proxy.SelectStudents();
        for (Student student : sList) {
            System.out.println(student);
        }*/
        Student student = new Student();
        student.setName("cxk");
        student.setAge(13);
        student.setEmail("北京");
        proxy.insertStudent(student);
    }
}
