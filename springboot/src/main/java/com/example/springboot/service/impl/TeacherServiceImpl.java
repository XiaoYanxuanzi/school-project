package com.example.springboot.service.impl;

import com.example.springboot.domain.Teacher;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private AttendanceMapper attendanceMapper;


    @Override
    public void updateAttendanceStatus(Long attendanceId, String newStatus) {
        attendanceMapper.updateAttendance(attendanceId,newStatus);
    }

    @Override
    public List<Teacher> getAllTeachersByNickname() {
        List<Teacher> allTeachers = teacherMapper.getAllTeachersByNickname();
        return allTeachers;
    }

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
