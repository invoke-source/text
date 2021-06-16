package com.bjpowernode.Service;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author Administrator
 * @2021/6/13 @16:47
 */
public interface StudentService {
    List<Student> SelectStudents();
    Integer insertStudent(Student student);
}
