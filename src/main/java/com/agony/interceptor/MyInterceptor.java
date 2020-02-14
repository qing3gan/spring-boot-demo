package com.agony.interceptor;

import com.agony.controller.HelloController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器(Interceptor): Spring组件，基于反射(AOP)，依赖Spring容器，处理Action请求(HttpServletRequest)
 * 过滤器(Filter): JavaEE组件(Servlet, Listener)，基于回调，依赖Servlet容器，处理所有请求(ServletRequest)
 *
 * Server Container -> Filter -> Servlet -> Interceptor -> Controller
 * Filter -> Service -> Dispatcher -> preHandle(true) -> Controller -> postHandle(chain) -> afterCompletion
 *
 * @author agony
 * @date 2020/2/14 11:00
 */
public class MyInterceptor implements HandlerInterceptor {
    private static final Log logger = LogFactory.getLog(HelloController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion");
    }
}
