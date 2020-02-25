package com.agony.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * ConfigurationProperties: 表示类型安全配置(Type-safe Configuration Properties)，将配置文件中的数据注入Bean中(prefix)
 * Annotation Processor: 编译时注解解析器（生成编译时源码或运行时字节码）
 * Lombok: 生成POJO基本方法
 *
 * @author agony
 * @date 2020/1/7 7:50
 */
@Component
@ConfigurationProperties(prefix = "book1")
@Getter
@Setter
@ToString
@Entity(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_name", nullable = false)
    private String name;
    @Column(name = "book_author", nullable = false)
    private String author;
    @JsonIgnore
    @Column(name = "book_price" , nullable = false)
    protected Float price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Transient
    private Date publishDate;
    @Transient
    private List<String> favorites;
}
