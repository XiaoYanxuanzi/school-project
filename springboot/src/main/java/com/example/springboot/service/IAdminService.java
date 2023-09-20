package com.example.springboot.service;

import com.example.springboot.domain.Admin;
import com.example.springboot.domain.Student;

public interface IAdminService {
    Admin login(Admin admin);
}
