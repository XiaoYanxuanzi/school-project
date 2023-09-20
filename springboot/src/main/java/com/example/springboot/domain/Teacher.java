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
     * 
     */
    private String roleId;

    private static final long serialVersionUID = 1L;
}