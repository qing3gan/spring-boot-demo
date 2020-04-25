package com.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * CacheConfig: 缓存配置（缓存名称）
 *
 * @author agony
 * @date 2020/4/25 16:08
 */
@Repository
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
    @Cacheable
    public Book getBookById(Long id) {
        System.out.println("getBookById");
        Book book = new Book();
        book.setId(id);
        book.setName("sanguoyanyi");
        book.setAuthor("luoguanzhong");
        return book;
    }

    @CachePut(key = "#book.id")
    public Book updateBookById(Book book) {
        System.out.println("updateBookById");
        book.setName("sanguoyanyi2");
        return book;
    }

    @CacheEvict(key = "#id")
    public void deleteBookById(Long id) {
        System.out.println("deleteBookById");
    }
}
