package com.agony.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * SpringBoot注解ConfigurationProperties表示类型安全配置(Type-safe Configuration Properties)
 * 将配置文件中的数据注入Bean中（prefix）
 * <p>
 * Annotation Processor编译时注解解析器(生成编译时源码或运行时字节码）
 * Lombok（生成POJO基本方法）
 *
 * @author agony
 * @date 2020/1/7 7:50
 */
@Component
@ConfigurationProperties(prefix = "book1")
@Getter
@Setter
@ToString
public class Book {
    private Integer id;
    private String name;
    private String author;
    @JsonIgnore
    protected Float price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private List<String> favorites;
}
