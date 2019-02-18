package com.tt.stu.dao;

import com.tt.stu.pojo.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SubjectDao {

    @Select("SELECT subject.*,grade.gradeName AS gradeName FROM subject,grade WHERE subject.gradeID = grade.gradeID")
    List<Subject> getSubjectList();

    @Insert("insert into subject(subjectName,classHour,gradeID) values(#{subjectName},#{classHour},#{gradeID})")
    int addSubject(Subject subject);
}
