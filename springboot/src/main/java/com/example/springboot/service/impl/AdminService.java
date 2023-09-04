package com.example.springboot.service.impl;

import com.example.springboot.domain.Admin;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> listadmins() {

        return adminMapper.listAdmins();
    }
}
