package com.example.springboot.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 管理员表
 * @TableName admin
 */
@Data
public class Admin implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 管理员唯一标识
     */
    private Integer adminId;

    /**
     * 
     */
    private Integer roleId;

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

    private static final long serialVersionUID = 1L;
}