package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BookRequest;
import com.example.springboot.domain.Book;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public PageInfo<Book> page(BookRequest bookRequest) {
        PageHelper.startPage(bookRequest.getPageNum(),bookRequest.getPageSize());
        List<Book> books = bookMapper.listByCondition(bookRequest);
        return new PageInfo<>(books);
    }

    @Override
    public void save(BookRequest bookRequest) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(BookRequest bookRequest) {

    }

    @Override
    public Book getById(Integer id) {
        return null;
    }
}
