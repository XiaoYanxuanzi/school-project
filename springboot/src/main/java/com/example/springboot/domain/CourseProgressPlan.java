package com.example.springboot.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 课程进度计划表
 * @TableName course_progress_plan
 */
@Data
public class CourseProgressPlan implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 课程计划表id
     */
    private Integer coursePlanId;

    /**
     * 周
     */
    private Integer week;

    /**
     * 星期几
     */
    private Integer dayOfWeek;

    /**
     * 上课时间表id
     */
    private Integer classScheduleId;

    private static final long serialVersionUID = 1L;
}