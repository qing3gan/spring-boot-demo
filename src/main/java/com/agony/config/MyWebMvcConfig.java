package com.agony.config;

import com.agony.interceptor.MyInterceptor;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 自定义Web Mvc配置
 * 1.HTTPMessageConverter（消息转换器）
 * 1.1.默认Jackson，默配Gson，自配FastJson
 * 2.ResourceHandler（静态资源处理）
 * 2.1.staticPathPattern默认/**
 * 2.2.resourceLocation默认classpath:resources/META-INF/resources -> resources/resources -> resources/static -> resources/public
 * 3.CorsMapping（跨域配置）
 * 3.1.Client(Host + Origin + Referer + {Access-Control-Request-Method}) -> Server(Access-Control-Allow-Origin +
 * {Access-Control-Allow-Origin + Access-Control-Allow-Methods + Access-Control-Max-Age + Allow})
 * 3.2.前端发起跨域请求，后端处理跨域请求并响应跨域结果（GET/POST/HEAD请求直接响应，DELETE/PUT/自定义请求则需要前端OPTIONS请求探测是否支持当前请求，
 * 后端响应支持结果（支持方法 + 时效），然后在时效内直接响应）
 * 4.Interceptor（拦截器）
 * 5.ViewController（路径映射，页面跳转）
 *
 * @author agony
 * @date 2020/1/13 23:48
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置多个路径
        registry
                .addResourceHandler("/**", "/static/**")
                .addResourceLocations("/", "classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("https://localhost:8082");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(("/hello"));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
