package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.StudentAttendanceMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;

@Service
public class StudentServiceImpl implements IStudentService {

    private StudentAttendanceMapper studentAttendanceMapper;

    @Override
    public void insert(StudentAttendance studentAttendance,HttpServletRequest request) {

        // 获取当前用户角色信息
        HttpSession roles = (HttpSession) request.getSession().getAttribute("roles");

        System.out.println(roles);

        if (studentAttendance.getStudentId() == null){
            throw new ServiceException("未获取到用户信息");
        }


        studentAttendance.setAttendanceTime(new Date());
        studentAttendanceMapper.insert(studentAttendance);
    }
}
