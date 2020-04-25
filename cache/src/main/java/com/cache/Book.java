package com.cache;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/23 22:59
 */
@Getter
@Setter
@ToString
public class Book implements Serializable {
    private Long id;
    private String name;
    private String author;
}
