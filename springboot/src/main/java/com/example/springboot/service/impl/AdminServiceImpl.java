package com.example.springboot.service.impl;

import com.example.springboot.domain.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        Admin username = adminMapper.selectUsername(admin);

        if (username == null){
            throw new ServiceException("管理员账号不存在，请添加管理员");
        }

        if (!username.getPassword().equals(admin.getPassword())){
            throw new ServiceException("账号或密码错误");
        }

        return username;
    }
}
