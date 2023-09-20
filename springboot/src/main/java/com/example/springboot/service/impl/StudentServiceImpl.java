package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.ClassSchedule;
import com.example.springboot.domain.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public void insert(Student student, Attendance attendance) {
        //查询所有studentId
        List<Integer> studentIds = attendanceMapper.findStudentIds();
        String today = DateUtil.today();


        if (student == null) {
            System.out.println(student);
            throw new ServiceException("未获取到学生信息");
        }

        attendance.setStudentId(student.getId());

        if (studentIds.contains(attendance.getStudentId())) {
            throw new ServiceException("该学生已经存在打卡记录");
        }

        attendance.setAttendanceTime(new Date());
        attendance.setAttendanceDay(today);
        attendance.setAttendance("打卡");
        attendance.setIsAttended("是");

        attendanceMapper.insert(attendance);
    }


    @Override
    public Student login(Student student) {
        Student number = studentMapper.selectStudentNumber(student);

        if (number == null) {
            throw new ServiceException("账号不存在，请注册");
        }

        if (!number.getPassword().equals(student.getPassword())) {
            throw new ServiceException("账号或密码错误");
        }

        return number;
    }

    @Override
    public Student register(Student student) {
        Student number = studentMapper.selectStudentNumber(student);

        if (number != null) {
            throw new ServiceException("用户已存在");
        }

        student.setNickname(student.getUsername());
        studentMapper.insertStudent(student);
        return student;
    }

}
