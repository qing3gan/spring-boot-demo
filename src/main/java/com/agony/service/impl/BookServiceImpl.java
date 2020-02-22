package com.agony.service.impl;

import com.agony.dao.BookDao;
import com.agony.dao.BookJpa;
import com.agony.entity.Book;
import com.agony.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private BookJpa bookJpa;

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

    @Override
    public void saveBook(Book book) {
        bookJpa.save(book);
    }

    @Override
    public Page<Book> getBooksByPage(Pageable pageable) {
        return bookJpa.findAll(pageable);
    }

    @Override
    public List<Book> getBooksByAuthorStartingWish(String author) {
        return bookJpa.getBooksByAuthorStartingWith(author);
    }

    @Override
    public List<Book> getBooksByPriceGreaterThan(Float price) {
        return bookJpa.getBooksByPriceGreaterThan(price);
    }

    @Override
    public Book getMaxIdBook() {
        return bookJpa.getMaxIdBook();
    }

    @Override
    public List<Book> getBooksByIdAndAuthor(Integer id, String author) {
        return bookJpa.getBooksByIdAndAuthor(id, author);
    }

    @Override
    public List<Book> getBooksByIdAndName(Integer id, String name) {
        return bookJpa.getBooksByIdAndName(id, name);
    }
}
