package com.example.springboot.service.impl;


import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.StudentAttendanceMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentAttendanceMapper studentAttendanceMapper;

    @Override
    public void insert(Roles roles, StudentAttendance studentAttendance) {

        if (roles == null){
            throw new ServiceException("未获取到用户信息1");
        }

        studentAttendance.setStudentId(roles.getId());

        if (studentAttendance.getStudentId() == null){
            throw new ServiceException("未获取到用户信息2");
        }


        studentAttendance.setAttendanceTime(new Date());
        System.out.println(studentAttendance);

        studentAttendanceMapper.insert(studentAttendance);

    }
}
