package com.example.springboot.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 班级表
 * @TableName class
 */
@Data
public class Class implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String className;

    /**
     * 专业计划表id
     */
    private Integer majorPlanId;

    private static final long serialVersionUID = 1L;
}