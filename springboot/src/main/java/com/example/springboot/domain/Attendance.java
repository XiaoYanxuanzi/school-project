package com.example.springboot.domain;

import java.io.Serializable;
import java.util.Date;

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
     * 出席情况 迟到 旷课
     */
    private String attendance;

    /**
     * 是否已考勤
     */
    private String isAttended;

    private static final long serialVersionUID = 1L;
}