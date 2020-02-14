package com.agony.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * CommandLineRunner: 系统任务，系统参数(args)，系统启动时执行，初始化操作
 * Order(priority): 启动顺序，数字小优先级高
 *
 * @author agony
 * @date 2020/2/14 11:48
 */
@Component
@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    private static final Log logger = LogFactory.getLog(MyCommandLineRunner1.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info(Arrays.toString(args));
    }
}
