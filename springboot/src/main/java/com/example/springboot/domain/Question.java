package com.example.springboot.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 聊天表
 * @TableName question
 */
@Data
public class Question implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sendTime;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 老师id
     */
    private Integer teacherId;

    private static final long serialVersionUID = 1L;
}