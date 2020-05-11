package com.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/11 22:40
 */
@Getter
@Setter
public class Menu {
    private Integer id;
    private String pattern;
    private List<Role> roles;
}
