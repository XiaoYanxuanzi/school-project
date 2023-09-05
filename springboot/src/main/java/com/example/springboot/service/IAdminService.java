package com.example.springboot.service;

import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {

//    List<Admin> listadmins();

    PageInfo<Admin> page(AdminPageRequest adminPageRequest);
}
