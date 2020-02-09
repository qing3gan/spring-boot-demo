package com.agony;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Spring(Bean) -> Spring Boot(Auto)
 * SpringBootApplication为SpringBoot注解
 * 1.SpringBoot注解EnableAutoConfiguration,SpringBootConfiguration和Spring注解ComponentScan注解组合
 * 2.EnableAutoConfiguration注解表示自动化配置项目中的依赖（此项目中为Spring和SpringMVC）
 * 3.SpringBootConfiguration注解表示该类是配置类（可配置Bean）
 * 4.ComponentScan注解表示扫描当前类包路径下的类并注入到容器当中（放在根包下，扫描Service,Repository,Component,Controller,RestController）
 *
 * @author agony
 * @date 2020/1/5 20:27
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        builder.application().setAdditionalProfiles("prod");
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
