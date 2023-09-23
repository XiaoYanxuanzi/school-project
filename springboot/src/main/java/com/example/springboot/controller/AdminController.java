package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.Student;
import com.example.springboot.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;



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
