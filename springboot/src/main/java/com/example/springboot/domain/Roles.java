package com.example.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色表
 * @TableName roles
 */
@Data
public class Roles implements Serializable {
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 角色 0学生 1老师 2辅导员 3管理员
     */
    private String role_type;

    private static final long serialVersionUID = 1L;
}