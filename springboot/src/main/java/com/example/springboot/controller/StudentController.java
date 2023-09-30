package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.domain.*;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.service.impl.QuestionServiceImpl;
import com.example.springboot.service.impl.StudentServiceImpl;
import com.example.springboot.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Resource
    private StudentServiceImpl studentService;

    @Resource
    private QuestionServiceImpl questionService;

    @Resource
    private TeacherServiceImpl teacherService;



    @PostMapping("/ask")
    public Result askQuestion(@RequestBody Question question,HttpServletRequest request){
        Object student = request.getSession().getAttribute("student");
        if (student == null) {
            throw new ServiceException("未登录");
        }
        questionService.save(question,(Student)student);
        return Result.success();
    }

    /**
     * 获取所有教师名称
     * @return
     */
    @GetMapping("/getAll")
    public Result getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachersByNickname();
        return Result.success(teachers);
    }

    /**
     * 学生打卡
     * @param attendance
     * @param request
     * @return
     */
    @PostMapping("/attendance")
    public Result attendance(@RequestBody Attendance attendance, HttpServletRequest request,ClassSchedule classSchedule) {
        Object student = request.getSession().getAttribute("student");
        if (student == null) {
            throw new ServiceException("未登录");
        }

        studentService.insert((Student) student,attendance,classSchedule);
        System.out.println(student);
        return Result.success();
    }

    /**
     * 学生退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
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
        request.getSession().setAttribute("student", login);
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
