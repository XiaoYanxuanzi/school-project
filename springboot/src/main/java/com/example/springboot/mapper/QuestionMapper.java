package com.example.springboot.mapper;

import com.example.springboot.domain.Question;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【question(聊天表)】的数据库操作Mapper
* @createDate 2023-09-25 13:04:09
* @Entity com.example.springboot.domain.Question
*/
@Mapper
public interface QuestionMapper {

    void save(Question question);
}




