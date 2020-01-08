package com.agony.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SpringBoot注解ConfigurationProperties表示类型安全配置(Type-safe Configuration Properties)
 * 将配置文件中的数据注入Bean中
 *
 * Annotation Processor编译时注解解析器(生成运行时源码或字节码）
 * Lombok（生成POJO基本方法）
 *
 * @author agony
 * @date 2020/1/7 7:50
 */
@Component
@ConfigurationProperties(prefix = "book")
@Getter
@Setter
@ToString
public class Book {
    private String name;
    private String author;
    private Float price;
}
