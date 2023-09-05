package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

//    /**
//     * 查询用户列表
//     * @return
//     */
//    @GetMapping("/list")
//    public Result listUsers(){
//        List<User> users = userService.listusers();
//        return Result.success(users);
//    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/pages")
    public Result Pages(UserPageRequest userPageRequest){

        return Result.success(userService.page(userPageRequest));
    }

}
