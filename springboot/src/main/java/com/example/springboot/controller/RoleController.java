package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.domain.Roles;
import com.example.springboot.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    /**
     * 角色登录
     * @param role
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Roles role){
        Roles roles = roleService.login(role);
        System.out.println(roles);
        return Result.success(roles);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Roles role){
        Roles roles = roleService.register(role);
        return Result.success(roles);
    }
}
