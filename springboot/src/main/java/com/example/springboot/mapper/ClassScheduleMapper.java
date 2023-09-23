package com.example.springboot.mapper;


import com.example.springboot.domain.ClassSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【class_schedule(上课时间表)】的数据库操作Mapper
* @createDate 2023-09-20 22:10:53
* @Entity com.example.springboot.domain.ClassSchedule
*/
@Mapper
public interface ClassScheduleMapper {

    List<ClassSchedule> findByTime();
}




