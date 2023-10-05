package com.example.springboot.mapper;

import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherAndClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Mapper
* @createDate 2023-09-18 13:34:25
* @Entity com.example.springboot.domain.Admin
*/
@Mapper
public interface AdminMapper {

    Admin selectUsername(Admin admin);

    List<StudentAndClass> listByStudent(StudentPageRequest studentPageRequest);

    List<TeacherAndClass> listByTeacher(TeacherPageRequest teacherPageRequest);
}




