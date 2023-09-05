package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-09-03 10:46:10
* @Entity com.example.springboot.domain.user
*/
@Mapper
public interface UserMapper {

//    @Select("select  * from user")
//    List<User> listUsers();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    void deleteById(Integer id);

    void updateById(User user);

    User getById(Integer id);
}
