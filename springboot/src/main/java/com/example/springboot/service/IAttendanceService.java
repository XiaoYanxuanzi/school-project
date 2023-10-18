package com.example.springboot.service;

import com.example.springboot.domain.Attendance;

import java.util.List;

public interface IAttendanceService{

    List<Attendance> getAttendanceWithCourseProgressPlan(int courseProgressId);
}
