package com.agony.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Mybatis多数据源配置
 *
 * @author agony
 * @date 2020/2/25 20:17
 */
@Configuration
@MapperScan(value = "com.agony.mapper2", sqlSessionFactoryRef = "sqlSessionFactoryBeanTwo")
public class MyBatisConfigTwo {
    @Autowired
    @Qualifier("dataSourceTwo")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBeanTwo() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTwo() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBeanTwo());
    }
}
