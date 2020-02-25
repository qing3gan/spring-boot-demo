package com.agony.mapper1;

import com.agony.entity.Book;

import java.util.List;

/**
 * 面向接口编程: 抽象实现，暴露接口（持久层切换）
 *
 * @author agony
 * @date 2020/2/15 16:40
 */
public interface BookMapperOne {
    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBooks();
}
