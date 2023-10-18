package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.ChatListPageRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.domain.Attendance;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.ClassDeskMessage;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherQuestion;
import com.example.springboot.service.impl.AttendanceServiceImpl;
import com.example.springboot.service.impl.StudentServiceImpl;
import com.example.springboot.service.impl.TeacherServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherServiceImpl teacherService;

    @Resource
    private StudentServiceImpl studentService;

    @Resource
    private AttendanceServiceImpl attendanceService;

    @GetMapping("/course-progress/{courseProgressId}")
    public List<Attendance> getAttendanceWithCourseProgressPlan(@PathVariable int courseProgressId) {
        return attendanceService.getAttendanceWithCourseProgressPlan(courseProgressId);
    }


    /**
     * 根据id返回学生信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Student studentId = studentService.getById(id);
        return Result.success(studentId);
    }

    /**
     * 获取教师课堂信息
     * @return
     */
    @GetMapping("/classes")
    public List<ClassDeskMessage> getAllClasses() {
        return teacherService.getAllClasses();
    }

    /**
     * 新增教师信息
     * @param teacher
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return Result.success();
    }

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
