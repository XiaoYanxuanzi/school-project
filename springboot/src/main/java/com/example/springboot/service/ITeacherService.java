package com.example.springboot.service;

import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.domain.Question;
import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.TeacherQuestion;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ITeacherService {

    Teacher login(Teacher teacher);

    Teacher register(Teacher teacher);

    void updateAttendanceStatus(Long attendanceId, String newStatus);

    List<Teacher> getAllTeachersByNickname();

    PageInfo<TeacherQuestion> page(ChatListPageRequest chatListPageRequest);
}
