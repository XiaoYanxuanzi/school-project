package com.example.springboot.domain;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "HH:mm:ss")
    private Time startTime;

    /**
     * 上课结束时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    private Time endTime;

    private static final long serialVersionUID = 1L;
}