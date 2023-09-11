package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.domain.Roles;

import javax.management.relation.Role;

public interface IRoleService {
    Roles login(Roles role);

    Roles register(Roles role);
}
