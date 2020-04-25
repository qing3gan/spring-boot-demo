package com.cache;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis多数据源配置
 * RedisClusterConfiguration: 分布式集群配置
 * JedisConnectionFactory: 连接池工厂
 * RedisTemplate: 操作模板
 *
 * @author agony
 * @date 2020/3/5 23:30
 */
@Configuration
@ConfigurationProperties("spring.redis.cluster")
@Getter
@Setter
public class RedisConfig {
    private List<Integer> ports;
    private String host;
    private JedisPoolConfig poolConfig;

    @Bean
    public RedisClusterConfiguration redisClusterConfiguration() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        List<RedisNode> nodes = new ArrayList<>();
        for (Integer port : ports) {
            nodes.add(new RedisNode(host, port));
        }
        configuration.setPassword(RedisPassword.of("root"));
        configuration.setClusterNodes(nodes);
        return configuration;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(redisClusterConfiguration(), poolConfig);
    }
}
