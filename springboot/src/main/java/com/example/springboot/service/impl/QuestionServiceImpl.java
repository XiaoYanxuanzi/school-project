package com.example.springboot.service.impl;


import com.example.springboot.domain.Question;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.mapper.QuestionMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public void save(Question question, Student student) {
        // 获取当前日期和时间
        Date date = new Date();
        question.setSendTime(date);
        question.setStudentId(student.getId());
        questionMapper.save(question);
    }
}
