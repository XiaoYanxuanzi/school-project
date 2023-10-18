package com.example.springboot.service.impl;

import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.domain.Question;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.mapper.AttendanceMapper;
import com.example.springboot.mapper.QuestionMapper;
import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.model.dto.ClassDeskMessage;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherAndClass;
import com.example.springboot.model.dto.TeacherQuestion;
import com.example.springboot.service.ITeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private AdminMapper adminMapper;


    @Override
    public void updateAttendanceStatus(Long attendanceId, String newStatus) {
        attendanceMapper.updateAttendance(attendanceId,newStatus);
    }

    @Override
    public List<Teacher> getAllTeachersByNickname() {
        List<Teacher> allTeachers = teacherMapper.getAllTeachersByNickname();
        return allTeachers;
    }

    @Override
    public PageInfo<TeacherQuestion> pageQuestion(ChatListPageRequest chatListPageRequest,Teacher teacher) {
        PageHelper.startPage(chatListPageRequest.getPageNum(), chatListPageRequest.getPageSize());
        // 获取当前老师的ID
        Integer teacherId = teacher.getId();
        List<TeacherQuestion> questions = questionMapper.listByCondition(chatListPageRequest.getTitle(),teacherId);
        return new PageInfo<>(questions);
    }

    @Override
    public PageInfo<StudentAndClass> pageStudent(StudentPageRequest studentPageRequest) {
        PageHelper.startPage(studentPageRequest.getPageNum(), studentPageRequest.getPageSize());
        List<StudentAndClass> students = adminMapper.listByStudent(studentPageRequest);
        return new PageInfo<>(students);
    }

    @Override
    public PageInfo<TeacherAndClass> pageTeacher(TeacherPageRequest teacherPageRequest) {
        PageHelper.startPage(teacherPageRequest.getPageNum(), teacherPageRequest.getPageSize());
        List<TeacherAndClass> teachers = adminMapper.listByTeacher(teacherPageRequest);
        return new PageInfo<>(teachers);
    }

    @Override
    public void save(Teacher teacher) {
        teacherMapper.save();
    }

    @Override
    public List<ClassDeskMessage> getAllClasses() {
        List<ClassDeskMessage> allClasses = teacherMapper.getAllClasses();
        return allClasses;
    }


    @Override
    public Teacher login(Teacher teacher) {
        Teacher username= teacherMapper.selectUsername(teacher);

        if (username == null){
            throw new ServiceException("该老师账号不存在");
        }

        if (!username.getPassword().equals(teacher.getPassword())){
            throw new ServiceException("账号或密码错误");
        }

        return username;
    }

    @Override
    public Teacher register(Teacher teacher) {
        Teacher selectUsername = teacherMapper.selectUsername(teacher);

        if (selectUsername != null) {
            throw new ServiceException("用户已存在");
        }

        teacher.setNickname(teacher.getUsername());
        teacherMapper.insertTeacher(teacher);
        return teacher;

    }


}
