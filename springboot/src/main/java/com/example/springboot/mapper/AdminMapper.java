package com.example.springboot.mapper;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-09-04 11:49:36
* @Entity com.example.springboot.domain.Admin
*/
@Mapper
public interface AdminMapper {

//    List<Admin> listAdmins();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin admin);

    Admin getById(Integer id);

    Admin getByUsernameAndPassword(LoginRequest request);

    void deleteById(Integer id);

    void update(Admin admin);

}
