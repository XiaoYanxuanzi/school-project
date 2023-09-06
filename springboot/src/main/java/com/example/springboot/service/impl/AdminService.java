package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.User;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public PageInfo<Admin> page(AdminPageRequest adminPageRequest) {
        PageHelper.startPage(adminPageRequest.getPageNum(), adminPageRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(adminPageRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.save(admin);
    }

    @Override
    public Admin getById(Integer id) {
       return adminMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.update(admin);
    }


//    @Override
//    public List<Admin> listadmins() {
//
//        return adminMapper.listAdmins();
//    }


}
