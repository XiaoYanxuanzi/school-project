package com.example.springboot.mapper;

import com.example.springboot.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2023-09-18 13:21:19
* @Entity com.example.springboot.domain.Student
*/
@Mapper
public interface StudentMapper {

    //根据用户名查询学生
    Student selectStudentNumber(Student student);

    //注册学生账号
    void insertStudent(Student student);


}




