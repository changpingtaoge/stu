package com.tt.stu.service.impl;

import com.tt.stu.dao.SubjectDao;
import com.tt.stu.pojo.Subject;
import com.tt.stu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> getSubjectList() {
        return subjectDao.getSubjectList();
    }

    @Transactional
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }
}
