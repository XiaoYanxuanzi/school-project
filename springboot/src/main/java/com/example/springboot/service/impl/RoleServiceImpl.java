package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.domain.Roles;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.RolesMapper;
import com.example.springboot.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RolesMapper rolesMapper;


    @Override
    public Roles login(Roles role) {
        Roles roles = rolesMapper.selectUsername(role);
        if (roles == null){
            throw new ServiceException("账号不存在，请注册");
        }

        if (!roles.getPassword().equals(role.getPassword())){
            throw new ServiceException("账号或密码错误");
        }
        return roles;
    }

    @Override
    public Roles register(Roles role) {
        Roles roles = rolesMapper.selectUsername(role);
        if (roles != null) {
            throw new ServiceException("用户已存在");
        }

        role.setNickname(role.getUsername());
        rolesMapper.insertRole(role);
        return role;
    }

    @Override
    public PageInfo<Roles> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Roles> users = rolesMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }
}
