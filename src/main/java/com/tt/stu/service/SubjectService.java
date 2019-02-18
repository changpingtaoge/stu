package com.tt.stu.service;

import com.tt.stu.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjectList();

    int addSubject(Subject subject);
}
