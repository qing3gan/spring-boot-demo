package com.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/4 21:47
 */
@Getter
@Setter
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String nameZh;
}
