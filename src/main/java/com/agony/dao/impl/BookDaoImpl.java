package com.agony.dao.impl;

import com.agony.dao.BookDao;
import com.agony.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * JdbcTemplate: 基于AOP的JDBC(update(CUD), query(Retrieve, RowMapper), execute(CURD), call(Procedure))
 * Repository: 持久层
 *
 * @author agony
 * @date 2020/2/15 16:43
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO t_book(name,author) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public int updateBook(Book book) {
        return jdbcTemplate.update("UPDATE t_book SET name=?,author=? WHERE id=?", book.getName(), book.getAuthor(), book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        return jdbcTemplate.update("DELETE FROM t_book WHERE id=?", id);
    }

    @Override
    public Book getBookById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT id,name,author FROM t_book WHERE id=?", new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT id,name,author FROM t_book", new BeanPropertyRowMapper<>(Book.class));
    }
}
