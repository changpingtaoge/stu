package com.tt.stu.controller;

import com.tt.stu.pojo.Student;
import com.tt.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "/student/login";
    }


    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpSession session) {
        String studentNo = request.getParameter("studentNo");
        Integer xuehao = Integer.parseInt(studentNo);
        String loginPwd = request.getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(xuehao);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1!=null){
            session.setAttribute("studentName",student1.getStudentName());
            return "/student/index";
        }
        return "/student/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("studentName");
        return "/student/login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session) {
        String name = (String) session.getAttribute("studentName");
        if (name!=null){
            return "/student/index";
        }
        return "/student/login";
    }

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentList() {
        List<Student> list = studentService.getStudentList();
        return list;
    }

    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public String studentList() {
        return "/student/studentList";
    }

    @RequestMapping(value = "/deleteStu/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStu(@PathVariable Integer stuNo) {
        int result = studentService.deleteStu(stuNo);
        if (result>0){
            return "删除成功！";
        }
        return "删除失败！";
    }

    @RequestMapping(value = "/updateStu",method = RequestMethod.POST)
    public String updateStu(HttpServletRequest request) {
        Student student = new Student();
        String stuNo =  request.getParameter("stuNo");
        Integer studentNo = Integer.parseInt(stuNo);
        student.setStudentNo(studentNo);
        student.setStudentName(request.getParameter("stuName"));
        student.setLoginPwd(request.getParameter("stuPwd"));
        student.setPhone(request.getParameter("stuPhone"));
        int result = studentService.updateStu(student);
        if (result>0){
            return "/student/studentList";
        }
        return "/student/studentList";
    }
}
