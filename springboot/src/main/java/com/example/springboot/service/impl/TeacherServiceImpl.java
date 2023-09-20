package com.example.springboot.service.impl;

import com.example.springboot.domain.Teacher;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(Teacher teacher) {
        Teacher username= teacherMapper.selectUsername(teacher);

        if (username == null){
            throw new ServiceException("该老师账号不存在");
        }

        if (!username.getPassword().equals(teacher.getPassword())){
            throw new ServiceException("账号或密码错误");
        }

        return username;
    }

    @Override
    public Teacher register(Teacher teacher) {
        Teacher selectUsername = teacherMapper.selectUsername(teacher);

        if (selectUsername != null) {
            throw new ServiceException("用户已存在");
        }

        teacher.setNickname(teacher.getUsername());
        teacherMapper.insertTeacher(teacher);
        return teacher;

    }
}
