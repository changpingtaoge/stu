package com.tt.stu.controller;

import com.tt.stu.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Autowired
    private ResultService resultService;
}
