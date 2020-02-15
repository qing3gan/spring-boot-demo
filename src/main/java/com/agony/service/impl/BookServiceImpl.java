package com.agony.service.impl;

import com.agony.dao.BookDao;
import com.agony.entity.Book;
import com.agony.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service: 业务层
 *
 * @author agony
 * @date 2020/2/15 18:25
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
