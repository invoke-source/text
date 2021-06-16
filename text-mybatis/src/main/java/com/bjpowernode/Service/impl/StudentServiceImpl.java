package com.bjpowernode.Service.impl;

import com.bjpowernode.Dao.StudentDao;
import com.bjpowernode.Service.StudentService;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Administrator
 * @2021/6/13 @18:15
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> SelectStudents() {

        List<Student> sList = studentDao.SelectByStudent();
        SqlSessionUtil.SqlSessionClose();
        return sList;

    }

    @Override
    public Integer insertStudent(Student student) {
        this.studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
        Integer result = studentDao.insertByStudent(student);

        return result;
    }
}
