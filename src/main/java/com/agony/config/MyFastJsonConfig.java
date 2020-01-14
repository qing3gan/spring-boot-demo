//package com.agony.config;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.nio.charset.StandardCharsets;
//
///**
// * FastJson配置bean（SpringBoot无默认配置）
// *
// * @author agony
// * @date 2020/1/13 23:30
// */
//@Configuration
//public class MyFastJsonConfig {
//    @Bean
//    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setDateFormat("yyyy-MM-dd");
//        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteClassName,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
//        converter.setFastJsonConfig(fastJsonConfig);
//        return converter;
//    }
//}
