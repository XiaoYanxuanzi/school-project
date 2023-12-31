package com.example.springboot.domain;

import java.io.Serializable;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 学生考勤表
 * @TableName attendance
 */
@Data
public class Attendance implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 学生表id
     */
    private Integer studentId;

    /**
     * 打卡日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String attendanceDay;

    /**
     * 打卡时间
     */
    private Time attendanceTime;

    /**
     * 出席情况 迟到 旷课
     */
    private String attendance;

    /**
     * 是否已考勤
     */
    private String isAttended;

    /**
     * 迟到次数
     */
    private Integer lateNumber;

    /**
     * 缺席次数
     */
    private Integer absentNumber;

    private int courseProgressId;

    private CourseProgressPlan courseProgressPlan; // 添加对应的外键属性

    private static final long serialVersionUID = 1L;
}