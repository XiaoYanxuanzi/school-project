package com.example.springboot.service;

import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;

import java.util.List;

public interface ITeacherService {

    Teacher login(Teacher teacher);

    Teacher register(Teacher teacher);

    void updateAttendanceStatus(Long attendanceId, String newStatus);

    List<Teacher> getAllTeachersByNickname();
}
