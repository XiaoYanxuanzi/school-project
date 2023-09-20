package com.example.springboot.service;

import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;

public interface ITeacherService {

    Teacher login(Teacher teacher);

    Teacher register(Teacher teacher);
}
