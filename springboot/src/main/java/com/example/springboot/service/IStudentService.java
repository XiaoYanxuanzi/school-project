package com.example.springboot.service;

import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.ClassSchedule;
import com.example.springboot.domain.Student;

public interface IStudentService {

    Student login(Student student);

    Student register(Student student);

    void insert(Student student, Attendance attendance,ClassSchedule classSchedule);

}
