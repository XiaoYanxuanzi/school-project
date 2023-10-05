package com.example.springboot.model.dto;

import lombok.Data;

@Data
public class TeacherAndClass {

    /**
     *
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 角色id 0为老师 1为辅导员
     */
    private String roleId;

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;

    private static final long serialVersionUID = 1L;

}
