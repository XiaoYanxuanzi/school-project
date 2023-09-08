package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.CategoryRequest;
import com.example.springboot.domain.Category;
import com.example.springboot.domain.User;
import com.example.springboot.service.impl.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    /**
     * 图书分类添加
     * @param category
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Category category){
        categoryService.save(category);
        return Result.success();
    }

    /**
     * 图书分类列表
     * @param categoryRequest
     * @return
     */
    @GetMapping("/pages")
    public Result pages(CategoryRequest categoryRequest){
        PageInfo<Category> page = categoryService.page(categoryRequest);
        return Result.success(page);
    }
}
