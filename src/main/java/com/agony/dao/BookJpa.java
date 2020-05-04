package com.agony.dao;

import com.agony.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ORM：Object Relational Mapping（对象关系映射，通过使用描述对象和数据库之间映射的元数据，将面向对象语言程序中的对象自动持久化到关系数据库中）
 * JPA：Java Persistence API（ORM规范，Hibernate实现）
 * Spring Data：简化数据库访问，规范方法名称，减少数据库访问层代码（SQL，NoSQL）
 * JPA（简便） -> Spring Data JPA -> Hibernate/MyBatis(灵活）
 * JpaRepository：增删改查，分页查询，排序查询
 * JPQL：Java Persistence Query Language（面向对象表达式语言，绑定SQL，可移植，:属性，？索引）
 * Query：自定义查询（缓存）
 * Param：参数封装对象
 * Modifying：结合Query，修改操作
 *
 * @author agony
 * @date 2020/2/19 22:48
 */
public interface BookJpa extends JpaRepository<Book, Integer> {
    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id = (select max(id) from t_book)", nativeQuery = true)
    Book getMaxIdBook();

    @Query("select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBooksByIdAndAuthor(@Param("id") Integer id, @Param("author") String author);

    @Query("select b from t_book b where b.id<?1 and b.name like %?2%")
    List<Book> getBooksByIdAndName(@Param("id") Integer id, @Param("name") String name);
}
