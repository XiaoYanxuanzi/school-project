package com.example.springboot.mapper;

import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【student_attendance(学生考勤表)】的数据库操作Mapper
* @createDate 2023-09-15 21:09:22
* @Entity com.example.springboot.domain.StudentAttendance
*/
@Mapper
public interface StudentAttendanceMapper {

    void insert(StudentAttendance studentAttendance);

    List<Integer> findStudentIds();
}




