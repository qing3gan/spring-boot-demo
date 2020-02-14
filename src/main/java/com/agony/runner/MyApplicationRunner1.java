package com.agony.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner: 应用任务，应用参数(--key=value)
 * ApplicationRunner -> CommandLineRunner
 *
 * @author agony
 * @date 2020/2/14 11:56
 */
@Component
@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner {
    private static final Log logger = LogFactory.getLog(MyApplicationRunner1.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("NonOptionArgs: " + args.getNonOptionArgs());
        logger.info("OptionArgs: " + args.getOptionNames());
    }
}
