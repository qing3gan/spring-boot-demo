package com.agony.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * JdbcTemplate多数据源配置
 *
 * @author agony
 * @date 2020/2/24 22:50
 */
@Configuration
public class JdbcTemplateConfig {
    @Bean
    @Primary
    public JdbcTemplate jdbcTemplateOne(@Qualifier("dataSourceOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplateTwo(@Qualifier("dataSourceTwo") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
