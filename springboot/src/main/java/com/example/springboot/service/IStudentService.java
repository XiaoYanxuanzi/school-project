package com.example.springboot.service;

import com.example.springboot.domain.Roles;
import com.example.springboot.domain.StudentAttendance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface IStudentService {


    void insert(Roles roles, StudentAttendance studentAttendance);
}
