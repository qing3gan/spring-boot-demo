package com.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Actuator: 默认开启端点，不暴露端点
 * 原生端点: 应用配置类端点，度量指标类端点，操作控制类端点
 *
 * @author agony
 * @date 2020/5/26 20:58
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
