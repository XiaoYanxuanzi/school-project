package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Roles;
import com.example.springboot.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("roles"));
        request.getSession().removeAttribute("roles");
        return Result.success();
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Roles roles = roleService.getById(id);
        return Result.success(roles);
    }

    /**
     * 角色列表
     * @param userPageRequest
     * @return
     */
    @GetMapping("/pages")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(roleService.page(userPageRequest));
    }

    /**
     * 角色登录
     * @param role
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Roles role, HttpServletRequest request){
        Roles roles = roleService.login(role);
        request.getSession().setAttribute("roles",roles.getId());
        System.out.println(roles);
        return Result.success(roles);
    }

    /**
     * 角色注册
     * @param role
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Roles role){
        Roles roles = roleService.register(role);
        return Result.success(roles);
    }
}
