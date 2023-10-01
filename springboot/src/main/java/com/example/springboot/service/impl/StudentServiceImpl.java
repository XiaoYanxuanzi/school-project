package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.ClassSchedule;
import com.example.springboot.domain.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.mapper.ClassScheduleMapper;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Time;
import java.time.*;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private ClassScheduleMapper classScheduleMapper;

    // 凌晨自动执行
    @Scheduled(cron = "0 0 0 * * ?")
    public void checkAttendanceStatus() {
        
    }

    @Override
    public void insert(Student student, Attendance attendance,ClassSchedule classSchedule) {
        // 查询所有studentId
        List<Integer> studentIds = attendanceMapper.findStudentIds();
        // 获取今日日期
        String today = DateUtil.today();
        // 查询今天的上课时间表信息
        List<ClassSchedule> schedules = classScheduleMapper.findByTime();
        // 获取当前日期
        LocalTime currentTime = LocalTime.now();

        // 检查学生是否在课程时间范围内，并标记考勤
        boolean isWithinCourseTime = isWithinCourseTime(currentTime, schedules, attendance);

        // 如果不在课程时间范围内，标记为旷课
        if (!isWithinCourseTime) {
            markAttendanceAsAbsent(attendance, today);
        }

        // 如果在课程时间范围内，标记考勤
        markAttendance(attendance, today, student.getId(), studentIds, currentTime);
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

    /**
     * 检查学生是否在课程时间范围内，并标记考勤状态。
     * 如果学生在上课时间内，检查是否迟到。
     *
     * @param currentTime 当前时间
     * @param schedules   上课时间表
     * @param attendance  考勤记录
     * @return 如果在课程时间范围内，返回 true；否则返回 false。
     */
    private boolean isWithinCourseTime(LocalTime currentTime, List<ClassSchedule> schedules, Attendance attendance) {
        for (ClassSchedule schedule : schedules) {
            LocalTime startTime = schedule.getStartTime().toLocalTime();
            LocalTime endTime = schedule.getEndTime().toLocalTime();

            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                Duration timeDifference = Duration.between(startTime, currentTime);
                if (timeDifference.toMinutes() >= 5) {
                    attendance.setAttendance("迟到");
                } else {
                    attendance.setAttendance("打卡");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 标记考勤为旷课。
     *
     * @param attendance 考勤记录
     * @param today      当天日期
     */
    private void markAttendanceAsAbsent(Attendance attendance, String today) {
        attendance.setAttendanceTime(Time.valueOf(LocalTime.now()));
        attendance.setAttendanceDay(today);
        attendance.setAttendance("缺席");
        attendance.setIsAttended("否");
        attendanceMapper.updateAttendanceAttended(attendance);
    }

    /**
     * 标记考勤并更新数据库记录。
     *
     * @param attendance   考勤记录
     * @param today        当天日期
     * @param studentId    学生ID
     * @param studentIds   学生ID列表
     * @param currentTime  当前时间
     */
    private void markAttendance(Attendance attendance, String today, Integer studentId, List<Integer> studentIds, LocalTime currentTime) {
        attendance.setStudentId(studentId);
        attendance.setAttendanceDay(today);
        attendance.setIsAttended("是");
        attendance.setAttendanceTime(Time.valueOf(currentTime));

        // 如果学生已存在于数据库中，更新考勤信息；否则插入新记录
        if (studentIds.contains(studentId)) {
            attendanceMapper.update(attendance);
        } else {
            attendanceMapper.insert(attendance);
        }
    }

}
