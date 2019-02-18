package tt.stu.dao;

import tt.stu.pojo.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentno);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}