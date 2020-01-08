package com.agony.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * desc
 *
 * @author agony
 * @date 2020/1/9 7:28
 */
@Component
@ConfigurationProperties(prefix = "book2")
@Getter
@Setter
@ToString
public class Books {
    private List<Book> books;
}
