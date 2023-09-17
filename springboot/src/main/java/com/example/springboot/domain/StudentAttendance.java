package com.example.springboot.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 学生考勤表
 * @TableName student_attendance
 */
@Data
public class StudentAttendance implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 打卡时间
     */
    private Date attendanceTime;

    /**
     * 打卡日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String attendanceDay;

    /**
     * 打卡状态
     */
    private String attendanceStatus;

    /**
     * 附加说明
     */
    private String description;

    private static final long serialVersionUID = 1L;
}