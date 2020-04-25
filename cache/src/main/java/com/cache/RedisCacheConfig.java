package com.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * RedisConnectionFactory: Redis连接池工厂
 * RedisCacheManager: Redis缓存管理器
 * RedisCacheConfiguration: Redis缓存配置
 * RedisCacheWriter: Redis缓存写入器
 *
 * @author agony
 * @date 2020/4/25 17:11
 */
@Configuration
public class RedisCacheConfig {
    @Autowired
    RedisConnectionFactory factory;

    @Bean
    RedisCacheManager redisCacheManager() {
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .prefixKeysWith("book:")
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(30));
        configurationMap.put("c1", redisCacheConfiguration);
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter
                , RedisCacheConfiguration.defaultCacheConfig(), configurationMap);
        return redisCacheManager;
    }
}
