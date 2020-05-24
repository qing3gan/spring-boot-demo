package com.enterprise;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/24 12:10
 */
@SpringBootApplication
//@EnableScheduling
@EnableBatchProcessing
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

