package com.example.springboot.service;

import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.ClassSchedule;
import com.example.springboot.domain.Student;

import java.util.List;

public interface IStudentService {

    Student login(Student student);

    Student register(Student student);

    void insert(Student student, Attendance attendance);

}
