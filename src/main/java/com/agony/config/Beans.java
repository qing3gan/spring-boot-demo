package com.agony.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * XML配置
 *
 * @author agony
 * @date 2020/2/14 10:46
 */
@Configuration
@ImportResource("classpath:beans.xml")
public class Beans {
}
