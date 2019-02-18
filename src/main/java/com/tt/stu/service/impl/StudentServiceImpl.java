package com.tt.stu.service.impl;

import com.tt.stu.dao.StudentDao;
import com.tt.stu.pojo.Student;
import com.tt.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;


    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
    @Transactional
    public int deleteStu(Integer stuNo) {
        return studentDao.deleteStu(stuNo);
    }

    @Transactional
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }
}
