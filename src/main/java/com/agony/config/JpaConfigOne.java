package com.agony.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * JPA多数据源配置
 * EnableJpaRepositories: JPA配置（basePackages指定Repository位置， entityManagerFactoryRef指定实体类管理工厂
 * ， transactionManagerRef指定事务管理器）
 * EnableTransactionManagement: 事务管理
 * LocalContainerEntityManagerFactoryBean: 配置数据源 -> 设置JPA配置 -> 设置实体类位置 -> 配置持久化单元（多个EntityManagerFactory，必须指定持久化单元）
 * Primary: 优先使用实例
 *
 * @author agony
 * @date 2020/2/25 22:09
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.agony.dao1", "com.agony.dao"}, entityManagerFactoryRef = "entityManagerFactoryBeanOne"
        , transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfigOne {
    @Resource(name = "dataSourceOne")
    private DataSource dataSourceOne;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceOne)
                .properties(jpaProperties.getProperties())
                .packages("com.agony.model", "com.agony.entity")
                .persistenceUnit("pu1")
                .build();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBeanOne = entityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(factoryBeanOne.getObject());
    }
}
