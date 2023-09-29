package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.Teacher;
import com.example.springboot.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;


    /**
     * 修改学生出席情况
     * @param attendanceId
     * @param newStatus
     * @return
     */
    @PutMapping("/{attendanceId}")
    public Result updateAttendanceStatus(@PathVariable Long attendanceId, @RequestParam String newStatus) {
        teacherService.updateAttendanceStatus(attendanceId,newStatus);
        return Result.success();
    }

    /**
     * 教师登录
     * @param teacher
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Teacher teacher, HttpServletRequest request){
        Teacher login = teacherService.login(teacher);
        request.getSession().setAttribute("teacher",login);
        return Result.success();
    }

    /**
     * 教师注册
     * @param teacher
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Teacher teacher){
        Teacher register = teacherService.register(teacher);
        return Result.success(register);
    }
}
