package com.tt.stu.controller;

import com.tt.stu.pojo.Subject;
import com.tt.stu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController {
   @Autowired
   private SubjectService subjectService;

    @RequestMapping("/subjectList")
    public String subjectList() {
        return "/subject/subjectList";
    }

    @RequestMapping(value = "/getSubjectList",method = RequestMethod.GET)
    @ResponseBody
    public Object getSubjectList() {
        List<Subject> list = subjectService.getSubjectList();
        return list;
    }

    @RequestMapping(value = "addSubject")
    @ResponseBody
    public Object addSubject(@RequestParam String subjectName,@RequestParam Integer hours,@RequestParam Integer gradeID) {
        Subject subject = new Subject();
        subject.setGradeID(gradeID);
        subject.setClassHour(hours);
        subject.setSubjectName(subjectName);
        int result = subjectService.addSubject(subject);
        if (result>0){
            return "添加成功！";
        }
        return "添加失败！";
    }
}
