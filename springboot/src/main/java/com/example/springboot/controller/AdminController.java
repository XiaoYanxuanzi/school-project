package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("/pages")
    public Result Pages(AdminPageRequest adminPageRequest){
        PageInfo<Admin> page = adminService.page(adminPageRequest);
        return Result.success(page);
    }

//    @GetMapping("/list")
//    public Result AdminList(){
//        return Result.success(adminService.listadmins());
//    }
}
