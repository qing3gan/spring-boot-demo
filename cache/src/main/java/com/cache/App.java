package com.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * EnableCaching: 开启缓存
 * EhCache缓存，Redis单点缓存，Redis集群缓存
 *
 * @author agony
 * @date 2020/4/25 16:05
 */
@SpringBootApplication
@EnableCaching
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
