package com.example.springboot.service;

import com.example.springboot.controller.request.BookRequest;
import com.example.springboot.controller.request.CategoryRequest;
import com.example.springboot.domain.Book;
import com.example.springboot.domain.Category;
import com.github.pagehelper.PageInfo;


public interface IBookService {

    PageInfo<Book> page(BookRequest bookRequest);

    void save(BookRequest bookRequest);

    void deleteById(Integer id);

    void update(BookRequest bookRequest);

    Book getById(Integer id);
}
