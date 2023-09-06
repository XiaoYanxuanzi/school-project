package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.User;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PutMapping("/update")
    public Result update(@RequestBody Admin admin){
        adminService.update(admin);
        return Result.success();
    }

    /**
     * 管理员删除
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    /**
     * 管理员添加
     * @param admin
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Admin admin){
        System.out.println(admin);
        adminService.save(admin);
        return Result.success();
    }

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
