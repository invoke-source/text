package com.bjpowernode.Dao;


import com.bjpowernode.domain.Student;

import java.util.List;
/**
 * @author Administrator
 * @2021/6/13 @16:45
 */
public interface StudentDao {
    List<Student> SelectByStudent();
    Integer insertByStudent(Student student);

}
