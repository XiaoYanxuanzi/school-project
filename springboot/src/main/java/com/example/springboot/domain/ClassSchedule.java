package com.example.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 上课时间表
 * @TableName class_schedule
 */
@Data
public class ClassSchedule implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 课程节数
     */
    private Integer section;

    /**
     * 上课开始时间
     */
    private Date startTime;

    /**
     * 上课结束时间
     */
    private Date endTime;


    private static final long serialVersionUID = 1L;
}