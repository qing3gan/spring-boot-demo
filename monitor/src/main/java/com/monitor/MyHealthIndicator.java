package com.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义Health度量指标
 *
 * @author agony
 * @date 2020/5/26 22:01
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("msg", "my health").build();
    }
}
