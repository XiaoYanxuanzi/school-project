package com.example.springboot.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private String remark;
    private Integer pid;
    private LocalDate createtime;
    private LocalDate updatetime;

    private List<Category> children;


}
