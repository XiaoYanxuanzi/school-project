package com.example.springboot.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@Data
public class Student implements Serializable {
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
     * 年龄 0男 1女
     */
    private String sex;

    private static final long serialVersionUID = 1L;
}