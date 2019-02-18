package com.tt.stu.dao;

import com.tt.stu.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentDao {

    @Select("select * from student where studentNo = #{studentNo} and loginPwd = #{loginPwd}")
    Student doLogin(Student student);

    @Select("SELECT student.*,grade.gradeName AS gradeName FROM student,grade WHERE student.gradeId = grade.gradeID")
    List<Student> getStudentList();

    @Delete("delete from student where studentNo = #{stuNo}")
    int deleteStu(Integer stuNo);

    @Update("update student set studentName = #{studentName},loginPwd = #{loginPwd},phone=#{phone} where studentNo = #{studentNo}")
    int updateStu(Student student);
}
