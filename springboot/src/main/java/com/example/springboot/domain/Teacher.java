package com.example.springboot.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 老师表
 * @TableName teacher
 */
@Data
public class Teacher implements Serializable {
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

    private static final long serialVersionUID = 1L;
}