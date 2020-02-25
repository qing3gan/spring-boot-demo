package com.agony.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Mybatis多数据源配置
 * SqlSession的运行主要是依靠Executor执行器调用（调度）StatementHandler、parameterHandler、ResultSetHandler
 *
 * @author agony
 * @date 2020/2/25 20:17
 */
@Configuration
@MapperScan(value = "com.agony.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryBeanOne")
public class MyBatisConfigOne {
    @Autowired
    @Qualifier("dataSourceOne")
    private DataSource dataSource;

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryBeanOne() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBeanOne());
    }
}
