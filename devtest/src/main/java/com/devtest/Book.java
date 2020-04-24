package com.devtest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/23 22:59
 */
@Getter
@Setter
@ToString
public class Book {
    private Long id;
    private String name;
    private String author;
}
