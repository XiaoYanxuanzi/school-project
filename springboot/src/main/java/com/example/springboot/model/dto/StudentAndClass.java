package com.example.springboot.model.dto;

import lombok.Data;

@Data
public class StudentAndClass {

    /**
     * id
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
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 年龄
     */
    private String age;

    /**
     * 年龄
     */
    private String sex;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 学号
     */
    private String number;

    private static final long serialVersionUID = 1L;
}
