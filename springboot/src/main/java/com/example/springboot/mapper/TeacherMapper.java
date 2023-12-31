package com.example.springboot.mapper;

import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.ClassDeskMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【teacher(老师表)】的数据库操作Mapper
* @createDate 2023-09-18 13:34:25
* @Entity com.example.springboot.domain.Teacher
*/
@Mapper
public interface TeacherMapper {

    List<Teacher> getAllTeachersByNickname();

    Teacher selectUsername(Teacher teacher);

    void insertTeacher(Teacher teacher);

    void save();

    List<ClassDeskMessage> getAllClasses();
}




