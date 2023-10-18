package com.example.springboot.service.impl;

import com.example.springboot.domain.Attendance;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.service.IAttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;


    public List<Attendance> getAttendanceWithCourseProgressPlan(int courseProgressId) {
        return attendanceMapper.getAttendanceWithCourseProgressPlan(courseProgressId);
    }
}
