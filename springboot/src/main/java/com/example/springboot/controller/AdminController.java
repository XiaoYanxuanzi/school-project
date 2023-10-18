package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.domain.Admin;
import com.example.springboot.domain.Student;
import com.example.springboot.domain.Teacher;
import com.example.springboot.model.dto.StudentAndClass;
import com.example.springboot.model.dto.TeacherAndClass;
import com.example.springboot.service.impl.AdminServiceImpl;
import com.example.springboot.service.impl.StudentServiceImpl;
import com.example.springboot.service.impl.TeacherServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminServiceImpl adminService;

    @Resource
    private TeacherServiceImpl teacherService;

    @Resource
    private StudentServiceImpl studentService;

    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success();
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        studentService.deleteById(id);
        return Result.success();
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
     * 新增学生信息
     * @param student
     * @return
     */
    @PostMapping("/studentSave")
    public Result studentSave(@RequestBody Student student) {
        Student save = studentService.save(student);
        return Result.success();
    }

    /**
     * 显示教师列表
     * @param teacherPageRequest
     * @return
     */
    @GetMapping("/teacherPage")
    public Result teacherPage(TeacherPageRequest teacherPageRequest){
        PageInfo<TeacherAndClass> page = teacherService.pageTeacher(teacherPageRequest);

        return Result.success(page);
    }

    /**
     * 显示学生列表
     * @param studentPageRequest
     * @return
     */
    @GetMapping("/studentPage")
    public Result studentPage(StudentPageRequest studentPageRequest){
        PageInfo<StudentAndClass> page = teacherService.pageStudent(studentPageRequest);

        return Result.success(page);
    }

    /**
     * 管理员登录
     * @param admin
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request){
        Admin login = adminService.login(admin);
        request.getSession().setAttribute("admin",login);
        return Result.success();
    }
}
