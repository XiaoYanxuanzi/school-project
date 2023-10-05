package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherQuestion;
import com.example.springboot.service.impl.TeacherServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;


    /**
     * 显示聊天信息列表
     * @param chatListPageRequest
     * @return
     */
    @GetMapping("/chatPage")
    public Result selectByPage(ChatListPageRequest chatListPageRequest,HttpServletRequest request){
        Object teacher = request.getSession().getAttribute("teacher");
        PageInfo<TeacherQuestion> page = teacherService.pageQuestion(chatListPageRequest,(Teacher) teacher);

        return Result.success(page);
    }


    /**
     * 修改学生出席情况
     * @param attendanceId
     * @param newStatus
     * @return
     */
    @PutMapping("/{attendanceId}")
    public Result updateAttendanceStatus(@PathVariable Long attendanceId, @RequestParam String newStatus) {
        teacherService.updateAttendanceStatus(attendanceId,newStatus);
        return Result.success();
    }

    /**
     * 教师登录
     * @param teacher
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Teacher teacher, HttpServletRequest request){
        Teacher login = teacherService.login(teacher);
        request.getSession().setAttribute("teacher",login);
        System.out.println(login);
        return Result.success(login);
    }

    /**
     * 教师注册
     * @param teacher
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Teacher teacher){
        Teacher register = teacherService.register(teacher);
        return Result.success(register);
    }
}
