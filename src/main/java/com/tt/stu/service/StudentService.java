package com.tt.stu.service;

import com.tt.stu.pojo.Student;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> getStudentList();

    int deleteStu(Integer stuNo);

    int updateStu(Student student);
}
