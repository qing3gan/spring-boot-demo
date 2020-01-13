package com.agony.controller;

import com.agony.bean.Book;
import com.agony.bean.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * desc
 *
 * @author agony
 * @date 2020/1/7 8:00
 */
@RestController
@EnableConfigurationProperties(Book.class)
public class BookController {
    @Autowired
    private Book book;

    @Autowired
    private Books books;

    @GetMapping("/book/string")
    public String bookString() {
        return book.toString() + "\n" + books.toString();
    }

    @GetMapping("/book/json")
    public Book bookJson() {
        book.setPublishDate(new Date());
        return book;
    }

    @GetMapping("/books/{template}")
    public ModelAndView books(@PathVariable String template) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books.getBooks());
        mv.setViewName("books-" + template);
        return mv;
    }
}
