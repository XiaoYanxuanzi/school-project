package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.domain.StudentAttendance;
import com.example.springboot.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/insert")
    public Result insert(@RequestBody StudentAttendance studentAttendance, HttpServletRequest request) {
        HttpServletRequest roles = (HttpServletRequest) request.getSession().getAttribute("roles");
        System.out.println(roles);
        studentService.insert(studentAttendance, roles);
        return Result.success();
    }

}
