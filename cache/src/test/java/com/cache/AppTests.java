package com.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/25 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @Autowired
    BookDao bookDao;

    @Test
    public void contextLoads(){
        bookDao.getBookById(1L);
        bookDao.getBookById(1L);
        bookDao.deleteBookById(1L);
        Book book1 = bookDao.getBookById(1L);
        System.out.println(book1);
        Book book2 = new Book();
        book2.setId(1L);
        book2.setName("sanguoyanyi");
        book2.setAuthor("luoguanzhong");
        bookDao.updateBookById(book2);
        Book book3 = bookDao.getBookById(1L);
        System.out.println(book3);
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
