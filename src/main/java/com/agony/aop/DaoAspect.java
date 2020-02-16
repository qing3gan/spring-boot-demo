package com.agony.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/16 22:24
 */
@Component
@Aspect
public class DaoAspect {
    private static final Log logger = LogFactory.getLog(DaoAspect.class);

    @Pointcut("execution(* com.agony.dao.impl.BookDaoImpl.*(..))")
    public void dao() {
    }

    @After("dao()")
    public void after(JoinPoint joinPoint) {
        logger.info("after: " + joinPoint.getSignature().getName());
    }
}
