package com.agony.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/14 11:52
 */
@Component
@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {
    private static final Log logger = LogFactory.getLog(MyCommandLineRunner2.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info(Arrays.toString(args));
    }
}
