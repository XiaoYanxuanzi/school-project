package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherAndClass;
import com.example.springboot.service.impl.AdminServiceImpl;
import com.example.springboot.service.impl.TeacherServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminServiceImpl adminService;

    @Resource
    private TeacherServiceImpl teacherService;


    @GetMapping("/teacherPage")
    public Result teacherPage(TeacherPageRequest teacherPageRequest){
        PageInfo<TeacherAndClass> page = teacherService.pageTeacher(teacherPageRequest);

        return Result.success(page);
    }

    /**
     * 显示学生列表
     * @param studentPageRequest
     * @return
     */
    @GetMapping("/studentPage")
    public Result studentPage(StudentPageRequest studentPageRequest){
        PageInfo<StudentAndClass> page = teacherService.pageStudent(studentPageRequest);

        return Result.success(page);
    }

    /**
     * 管理员登录
     * @param admin
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request){
        Admin login = adminService.login(admin);
        request.getSession().setAttribute("admin",login);
        return Result.success();
    }
}
