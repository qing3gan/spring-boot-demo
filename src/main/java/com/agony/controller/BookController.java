package com.agony.controller;

import com.agony.entity.Book;
import com.agony.entity.Books;
import com.agony.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

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
        // PathVariable: URL占位符
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
        // jdbc generate insert auto increment id
        int id = bookService.addBook(book);
        // mybatis generate insert auto increment id
        id = book.getId();
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

    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageable = PageRequest.of(2, 3);
        Page<Book> page = bookService.getBooksByPage(pageable);
        logger.info("total pages: " + page.getTotalPages());
        logger.info("total elements: " + page.getTotalElements());
        logger.info("content: " + page.getContent());
        logger.info("number: " + (page.getNumber() + 1));
        logger.info("number of elements: " + page.getNumberOfElements());
        logger.info("size: " + page.getSize());
    }

    @GetMapping("/search")
    public void search() {
        List<Book> books = bookService.getBooksByIdAndAuthor(7, "鲁迅");
        List<Book> books2 = bookService.getBooksByAuthorStartingWish("吴");
        List<Book> books3 = bookService.getBooksByIdAndName(8, "西");
        List<Book> books4 = bookService.getBooksByPriceGreaterThan(30f);
        Book book = bookService.getMaxIdBook();
        logger.info("books: " + books);
        logger.info("books2: " + books2);
        logger.info("books3: " + books3);
        logger.info("books4: " + books4);
        logger.info("book: " + book);
    }

    @GetMapping("/save")
    public void save() {
        Book book = new Book();
        book.setAuthor("鲁迅");
        book.setName("呐喊");
        book.setPrice(23f);
        bookService.saveBook(book);
    }
}
