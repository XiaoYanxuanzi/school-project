package com.example.springboot.service.impl;


import cn.hutool.core.date.DateUtil;
import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.StudentAttendanceMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentAttendanceMapper studentAttendanceMapper;

    @Override
    public void insert(Roles roles, StudentAttendance studentAttendance) {
        Date date = new Date();
        List<Integer> studentIds = studentAttendanceMapper.findStudentIds();

        if (roles == null){
            throw new ServiceException("未获取到角色信息");
        }


        studentAttendance.setStudentId(roles.getId());
        studentAttendance.setAttendanceTime(new Date());
        studentAttendance.setAttendanceDay(DateUtil.format(date, "yyyy-MM-dd"));
        studentAttendance.setAttendanceStatus("1");

        /**
         * 校验一个账号一次打卡
         */
        if (studentIds.contains(studentAttendance.getStudentId())) {
            throw new ServiceException("该学生已经存在打卡记录");
        }

//        System.out.println(studentAttendance);

        studentAttendanceMapper.insert(studentAttendance);

    }


}
