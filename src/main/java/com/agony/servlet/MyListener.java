package com.agony.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Servlet3.0+
 *
 * @author agony
 * @date 2020/2/14 13:01
 */
@WebListener
public class MyListener implements ServletRequestListener {
    private static final Log logger = LogFactory.getLog(MyListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.info("requestInitialized");
    }
}
