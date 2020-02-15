package com.agony.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP(Aspect-Oriented Programming): 面向切面编程
 * Joinpoint(连接点): 类里面可以被增强的方法
 * Pointcut(切入点): 对Joinpoint进行拦截的定义
 * Advice(通知): 拦截到Joinpoint之后所要做的事情(Before -> After -> AfterReturning -> AfterThrowing -> Around)
 * Aspect(切面): Pointcut + Advice
 * Target(目标对象): 要增强的类
 *
 * @author agony
 * @date 2020/2/14 22:57
 */
@Component
@Aspect
public class LogAspect {
    private static final Log logger = LogFactory.getLog(LogAspect.class);

    @Pointcut("execution(* com.agony.service.impl.*.*(..))")
    public void log() {
    }

    @Before(value = "log()")
    public void before(JoinPoint joinPoint) {
        logger.info("before: " + joinPoint.getSignature().getName());
    }

    @After(value = "log()")
    public void after(JoinPoint joinPoint) {
        logger.info("after: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "log()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("afterReturning: " + joinPoint.getSignature().getName() + " return " + result);
    }

    @AfterThrowing(value = "log()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        logger.info("afterThrowing: " + joinPoint.getSignature().getName() + " throw " + e);
    }

    @Around(value = "log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("around: " + proceedingJoinPoint.getSignature().getName());
        return proceedingJoinPoint.proceed();
    }
}
