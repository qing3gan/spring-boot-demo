package com.agony.service.impl;

import com.agony.dao.BookDao;
import com.agony.dao.BookJpa;
import com.agony.entity.Book;
import com.agony.mapper.BookMapper;
import com.agony.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service: 业务层
 *
 * @author agony
 * @date 2020/2/15 18:25
 */
@Service
public class BookServiceImpl implements BookService {
    /**
     * JdbcTemplate
     */
    @Autowired
    private BookDao bookDao;

    /**
     * Mybatis
     */
    @Resource
    private BookMapper bookMapper;

    /**
     * Spring data jpa
     */
    @Autowired
    private BookJpa bookJpa;

    @Override
    public int addBookByJdbc(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBookByJdbc(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookByIdByJdbc(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book getBookByIdByJdbc(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Book> getAllBooksByJdbc() {
        return bookDao.getAllBooks();
    }

    @Override
    public int addBookByMapper(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int updateBookByMapper(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBookByIdByMapper(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public Book getBookByIdByMapper(Integer id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Book> getAllBooksByMapper() {
        return bookMapper.getAllBooks();
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
