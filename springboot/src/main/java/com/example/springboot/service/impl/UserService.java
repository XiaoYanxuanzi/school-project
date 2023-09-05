package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }
//    @Override
//    public List<User> listusers() {
//
//        return userMapper.listUsers();
//    }

    @Override
    public PageInfo<User> page(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(), userPageRequest.getPageSize());
        List<User> users = userMapper.listByCondition(userPageRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(User user) {
        Date date = new Date();
        // 当做卡号来处理
        user.setUsername(DateUtil.format(date, "yyyyMMdd") + Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        user.setAccount(0);
        userMapper.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateById(user);
    }


}
