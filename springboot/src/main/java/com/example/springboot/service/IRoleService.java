package com.example.springboot.service;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.domain.Roles;
import com.github.pagehelper.PageInfo;

public interface IRoleService {
    Roles login(Roles role);

    Roles register(Roles role);

    PageInfo<Roles> page(BaseRequest baseRequest);
}
