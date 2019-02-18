package com.tt.stu.service.impl;

import com.tt.stu.dao.ResultDao;
import com.tt.stu.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService{
    @Autowired
    private ResultDao resultDao;
}
