package com.agony.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * JPA多数据源配置
 *
 * @author agony
 * @date 2020/2/25 22:09
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.agony.dao2", entityManagerFactoryRef = "entityManagerFactoryBeanTwo"
        , transactionManagerRef = "platformTransactionManagerTwo")
public class JpaConfigTwo {
    @Resource(name = "dataSourceTwo")
    private DataSource dataSourceTwo;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceTwo)
                .properties(jpaProperties.getProperties())
                .packages("com.agony.model")
                .persistenceUnit("pu2")
                .build();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBeanTwo = entityManagerFactoryBeanTwo(builder);
        return new JpaTransactionManager(factoryBeanTwo.getObject());
    }
}
