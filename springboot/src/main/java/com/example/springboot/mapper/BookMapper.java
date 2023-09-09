package com.example.springboot.mapper;

import com.example.springboot.controller.request.BookRequest;
import com.example.springboot.controller.request.CategoryRequest;
import com.example.springboot.domain.Book;
import com.example.springboot.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-09-08 12:58:49
* @Entity com.example.springboot.domain.Book
*/
@Mapper
public interface BookMapper {

    List<Book> listByCondition(BookRequest bookRequest);

    void save(BookRequest bookRequest);

    Category getById(Integer id);

    void updateById(BookRequest bookRequest);

    void deleteById(Integer id);

}
