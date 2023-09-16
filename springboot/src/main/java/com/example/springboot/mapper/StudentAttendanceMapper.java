package com.example.springboot.mapper;

import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;

/**
* @author Administrator
* @description 针对表【student_attendance(学生考勤表)】的数据库操作Mapper
* @createDate 2023-09-15 21:09:22
* @Entity com.example.springboot.domain.StudentAttendance
*/
public interface StudentAttendanceMapper {

    void insert(StudentAttendance studentAttendance);

    StudentAttendance selectStudentId();
}




