package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/attendance")
    public Result attendance(@RequestBody Attendance attendance, HttpServletRequest request) {
        Object student = request.getSession().getAttribute("student");
        if (student == null) {
            throw new ServiceException("未登录");
        }
        if (attendance == null) {
            throw new ServiceException("参数错误");
        }
        studentService.insert((Student) student,attendance);
        System.out.println(student);
        return Result.success();
    }

    /**
     * 学生退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(@RequestBody HttpServletRequest request){
        request.getSession().removeAttribute("student");
        return Result.success();
    }

    /**
     * 学生登录
     * @param student
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Student student, HttpServletRequest request){
        Student login = studentService.login(student);
        request.getSession().setAttribute("student",login);
        System.out.println(login);
        return Result.success(login);
    }


    /**
     * 学生注册
     * @param student
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Student student) {
        Student register = studentService.register(student);
        return Result.success(register);
    }
}
