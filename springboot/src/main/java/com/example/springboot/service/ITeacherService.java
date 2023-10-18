package com.example.springboot.service;

import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.domain.Question;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.ClassDeskMessage;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherAndClass;
import com.example.springboot.model.dto.TeacherQuestion;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ITeacherService {

    Teacher login(Teacher teacher);

    Teacher register(Teacher teacher);

    void updateAttendanceStatus(Long attendanceId, String newStatus);

    List<Teacher> getAllTeachersByNickname();

    PageInfo<TeacherQuestion> pageQuestion(ChatListPageRequest chatListPageRequest,Teacher teacher);

    PageInfo<StudentAndClass> pageStudent(StudentPageRequest studentPageRequest);

    PageInfo<TeacherAndClass> pageTeacher(TeacherPageRequest teacherPageRequest);

    void save(Teacher teacher);

    List<ClassDeskMessage> getAllClasses();
}
