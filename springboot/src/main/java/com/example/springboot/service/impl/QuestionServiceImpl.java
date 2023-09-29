package com.example.springboot.service.impl;


import com.example.springboot.domain.Question;
import com.example.springboot.mapper.QuestionMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public void save(Question question) {
        questionMapper.save(question);
    }
}
