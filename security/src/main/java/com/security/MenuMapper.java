package com.security;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/11 22:40
 */
@Mapper
public interface MenuMapper {
    public List<Menu> getAllMenus();
}
