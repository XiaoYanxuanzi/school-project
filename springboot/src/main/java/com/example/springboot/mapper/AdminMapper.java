package com.example.springboot.mapper;

import com.example.springboot.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【admin(管理员表)】的数据库操作Mapper
* @createDate 2023-09-18 13:34:25
* @Entity com.example.springboot.domain.Admin
*/
@Mapper
public interface AdminMapper {

    Admin selectUsername(Admin admin);
}




