package com.agony;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * JavaSE(C/S) -> JavaEE(B/S) -> Spring(Bean) -> Spring MVC(Web) -> Spring Boot(Auto)
 * SpringBootApplication = EnableAutoConfiguration + SpringBootConfiguration + ComponentScan
 * EnableAutoConfiguration: 自动化配置项目中的依赖（此项目中为Spring和SpringMVC），exclude除去具体自动化配置类
 * SpringBootConfiguration: 该类是配置类（可配置Bean）
 * ComponentScan: 扫描当前类包路径下的类并注入到容器当中（放在根包下，扫描Indexed(Component(Controller, RestController， Service, Repository))）
 * Indexed: 依赖spring-context-indexer，为Spring模式注解添加索引，以提升应用启动性能
 * AliasFor: 注解属性别名（同一个注解内属性互为别名或继承父注解的属性的别名）
 * ServletComponentScan: 扫描Servlet, Filter, Listener
 * MapperScan: 扫描指定包路径下的Mybatis Mapper类（等价于在在每个接口上配置Mapper: 该类是Mybatis Mapper类）
 *
 * @author agony
 * @date 2020/1/5 20:27
 */
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ServletComponentScan
@MapperScan("com.agony.mapper")
public class App {
    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        builder.application().setAdditionalProfiles("prod");
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
