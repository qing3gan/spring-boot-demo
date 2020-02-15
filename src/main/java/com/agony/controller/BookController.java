package com.agony.controller;

import com.agony.entity.Book;
import com.agony.entity.Books;
import com.agony.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * EnableConfigurationProperties(.class) = Import(EnableConfigurationPropertiesImportSelector.class)
 * RequestMapping: HTTP 请求映射到 MVC 和 REST 控制器的处理方法上
 * Component: 扫描注入
 * Autowired: 自动注入
 * Controller: 控制层
 *
 * @author agony
 * @date 2020/1/7 8:00
 */
@RestController
@RequestMapping("/book")
@EnableConfigurationProperties(Book.class)
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private Book book;

    @Autowired
    private Books books;

    @Autowired
    private BookService bookService;

    @GetMapping("/string")
    public String bookString() {
        return book.toString() + "\n" + books.toString();
    }

    @GetMapping("/json")
    public Book bookJson() {
        book.setPublishDate(new Date());
        return book;
    }

    @GetMapping("/{template}")
    public ModelAndView books(@PathVariable String template) {
        //PathVariable: URL占位符
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books.getBooks());
        mv.setViewName("books-" + template);
        return mv;
    }

    @GetMapping("/ops")
    public void bookOps() {
        Book book = new Book();
        book.setName("西厢记");
        book.setAuthor("王实甫");
        int id = bookService.addBook(book);
        logger.info("addBook: " + id);
        logger.info("getBookById: " + bookService.getBookById(id));
        Book book2 = new Book();
        book2.setId(id);
        book2.setName("朝花夕拾");
        book2.setAuthor("鲁迅");
        logger.info("updateBook: " + bookService.updateBook(book2));
        logger.info("getBookById: " + bookService.getBookById(id));
        logger.info("deleteBookById: " + bookService.deleteBookById(id));
        logger.info("getAllBooks: " + bookService.getAllBooks());
    }
}
