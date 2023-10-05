package com.example.springboot.mapper;

import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.domain.Question;
import com.example.springboot.model.dto.TeacherQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【question(聊天表)】的数据库操作Mapper
* @createDate 2023-09-25 13:04:09
* @Entity com.example.springboot.domain.Question
*/
@Mapper
public interface QuestionMapper {

    void save(Question question);

    List<TeacherQuestion> listByCondition(String title,Integer teacherId);
}




