package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 会员添加
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 删除会员
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return Result.success();
    }

    /**
     * 编辑会员信息
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

}
