package com.agony.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * XML配置
 * Configuration: 用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法
 * ，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描
 * ，并用于构建bean定义，初始化Spring容器
 * Import: 引入JavaConfig配置
 * ImportResource: 引入XML配置
 *
 * @author agony
 * @date 2020/2/14 10:46
 */
@Configuration
@ImportResource("classpath:beans.xml")
public class Beans {
}
