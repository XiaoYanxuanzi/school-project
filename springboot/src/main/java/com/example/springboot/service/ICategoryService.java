package com.example.springboot.service;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.CategoryRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Category;
import com.example.springboot.domain.User;
import com.github.pagehelper.PageInfo;


public interface ICategoryService {

    PageInfo<Category> page(CategoryRequest categoryRequest);

    void save(Category category);

    void deleteById(Integer id);

    void update(Category category);

    Category getById(Integer id);
}
