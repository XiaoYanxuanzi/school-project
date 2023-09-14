package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.domain.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【roles(角色表)】的数据库操作Mapper
* @createDate 2023-09-09 23:00:17
* @Entity com.example.springboot.domain.Roles
*/
@Mapper
public interface RolesMapper {

    Roles selectUsername(Roles role);

    void insertRole(Roles role);

    List<Roles> listByCondition(BaseRequest baseRequest);
}




