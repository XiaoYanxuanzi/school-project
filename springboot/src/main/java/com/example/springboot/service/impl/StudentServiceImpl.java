package com.example.springboot.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.ClassSchedule;
import com.example.springboot.domain.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.mapper.ClassScheduleMapper;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private ClassScheduleMapper classScheduleMapper;

    @Override
    public void insert(Student student, Attendance attendance,ClassSchedule classSchedule) {
        //查询所有studentId
        List<Integer> studentIds = attendanceMapper.findStudentIds();
        //获取今日日期
        String today = DateUtil.today();
        //查询今天的上课时间表信息
        List<ClassSchedule> schedules = classScheduleMapper.findByTime();
        boolean isWithinCourseTime = false; // 定义标志变量，表示是否在课程时间范围内
        // 获取当前日期
        LocalTime currentTime = LocalTime.now();

        for (ClassSchedule schedule : schedules) {
            Time startTime = schedule.getStartTime();
            Time endTime = schedule.getEndTime();

            // 转换为LocalTime
            LocalTime startTimeLocal = startTime.toLocalTime();
            LocalTime endTimeLocal = endTime.toLocalTime();
            System.out.println("Start Time: " + startTime);
            System.out.println("End Time: " + endTime);

            // 检查当前时间是否在课程时间范围内
            if (currentTime.isAfter(startTimeLocal) && currentTime.isBefore(endTimeLocal)) {
                isWithinCourseTime = true;
                // 找到匹配的课程后退出循环
                break;
            }
        }

        if (!isWithinCourseTime) {
            throw new ServiceException("不在上课时间内，无法打卡");
        }


        attendance.setStudentId(student.getId());

        if (studentIds.contains(attendance.getStudentId())) {
            throw new ServiceException("该学生已经存在打卡记录");
        }

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
