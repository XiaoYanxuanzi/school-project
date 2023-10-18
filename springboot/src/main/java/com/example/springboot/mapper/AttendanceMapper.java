package com.example.springboot.mapper;

import com.example.springboot.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
* @author Administrator
* @description 针对表【attendance(学生考勤表)】的数据库操作Mapper
* @createDate 2023-09-18 22:24:49
* @Entity com.example.springboot.domain.Attendance
*/
@Mapper
public interface AttendanceMapper {

    void insert(Attendance attendance);

    //查询所有学生id列
    List<Integer> findStudentIds();

    //修改考勤记录（打卡和迟到）
    void update(Attendance attendance);

    //修改考勤记录（缺席）
    void updateAttendanceAttended(Attendance attendance);

    //根据id来修改状态（请假）
    void updateAttendance(Long attendanceId, String newStatus);

    List<Attendance> getAttendanceWithCourseProgressPlan(int courseProgressId);

    // ...
}




