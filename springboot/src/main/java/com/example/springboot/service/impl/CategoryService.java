package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.CategoryRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.domain.Category;
import com.example.springboot.domain.User;
import com.example.springboot.mapper.CategoryMapper;
import com.example.springboot.service.IAdminService;
import com.example.springboot.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public PageInfo<Category> page(CategoryRequest categoryRequest) {
        PageHelper.startPage(categoryRequest.getPageNum(), categoryRequest.getPageSize());//PageHelper.startPage()启动分页功能
        List<Category> categories = categoryMapper.listByCondition(categoryRequest);
        return new PageInfo<>(categories);//PageInfo<>(categories)方法，将查询结果封装成一个PageInfo对象，并将其作为方法的返回值。
    }

    @Override
    public void save(Category category) {
        Date date = new Date();
        categoryMapper.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public Category getById(Integer id) {
        return null;
    }
}
