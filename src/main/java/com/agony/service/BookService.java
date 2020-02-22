package com.agony.service;

import com.agony.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 面向接口编程: 抽象实现，暴露接口（服务调用）
 *
 * @author agony
 * @date 2020/2/15 16:39
 */
public interface BookService {
    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBooks();

    void saveBook(Book book);

    Page<Book> getBooksByPage(Pageable pageable);

    List<Book> getBooksByAuthorStartingWish(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    Book getMaxIdBook();

    List<Book> getBooksByIdAndAuthor(Integer id, String author);

    List<Book> getBooksByIdAndName(Integer id, String name);
}
