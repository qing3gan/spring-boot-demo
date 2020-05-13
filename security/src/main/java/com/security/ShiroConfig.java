package com.security;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Realm: 域
 * ShiroFilterChainDefinition: 权限配置
 * ShiroDialect: shiro tag
 *
 * @author agony
 * @date 2020/5/13 22:33
 */
@Configuration
public class ShiroConfig {
    @Bean
    Realm realm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("admin=admin,admin\n user=user,user");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
        filterChainDefinition.addPathDefinition("/login", "anon");
        filterChainDefinition.addPathDefinition("/doLogin", "anon");
        filterChainDefinition.addPathDefinition("/logout", "logout");
        filterChainDefinition.addPathDefinition("/**", "authc");
        return filterChainDefinition;
    }

    @Bean
    ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
