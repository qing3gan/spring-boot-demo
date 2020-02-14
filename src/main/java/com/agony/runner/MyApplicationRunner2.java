package com.agony.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/14 11:59
 */
@Component
@Order(2)
public class MyApplicationRunner2 implements ApplicationRunner {
    private static final Log logger = LogFactory.getLog(MyApplicationRunner2.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("NonOptionArgs: " + args.getNonOptionArgs());
        logger.info("OptionArgs: " + args.getOptionNames());
    }
}
