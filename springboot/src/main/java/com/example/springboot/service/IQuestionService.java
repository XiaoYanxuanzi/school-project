package com.example.springboot.service;

import com.example.springboot.domain.Question;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;

public interface IQuestionService {


    void save(Question question,Student student);
}
