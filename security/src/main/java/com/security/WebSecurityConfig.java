package com.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSecurityConfigurerAdapter: 自定义Security配置
 * AuthenticationManagerBuilder: 账户认证
 * HttpSecurity: HTTP请求授权
 * OtherSecurityConfig: 静态内部类多HttpSecurity配置（Authentication会被覆盖）
 * EnableGlobalMethodSecurity: 全局方法安全配置（pre调用前，post调用后，secured角色）
 *
 * @author agony
 * @date 2020/5/3 22:29
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存用户密码认证
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("$2a$10$pt.tMv6BddM6K8uV27SIquPc0F6EdgOPXC2T54.gCmGhVjg9A7bi.").roles("admin", "user")
//                .and()
//                .withUser("dba").password("$2a$10$mOQXMy19KN92l/gVK5.oje/p0gCNwwIswfgZNfwy9CeCiTkXFdx3i").roles("admin", "dba")
//                .and()
//                .withUser("user").password("$2a$10$C1PcNShSyvnHWFyUaSE.v.E.yEmNE0t6TMllA4OyZ0YOF8IyEwNRG").roles("user")
//                .and()
//                .withUser("other").password("$2a$10$bU6/jiM5pBct8s5RTMCR.eIOAW6ttsY.em7LMAqILWnfKgnwhIz3S").roles("other");

        //数据库用户密码认证
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("admin")
                .antMatchers("/user/**")
                .access("hasAnyRole('admin','user')")
                .antMatchers("/dba/**")
                .access("hasRole('admin') and hasRole('dba')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("passwd")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    httpServletResponse.setStatus(HttpStatus.OK.value());
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", HttpStatus.OK.value());
                    map.put("msg", principal);
                    ObjectMapper objectMapper = new ObjectMapper();
                    printWriter.write(objectMapper.writeValueAsString(map));
                    printWriter.flush();
                    printWriter.close();
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = httpServletResponse.getWriter();
                    httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", HttpStatus.FORBIDDEN.value());
                    map.put("msg", e.getMessage());
                    ObjectMapper objectMapper = new ObjectMapper();
                    printWriter.write(objectMapper.writeValueAsString(map));
                    printWriter.flush();
                    printWriter.close();
                })
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler((httpServletRequest, httpServletResponse, authentication) -> {
                })
                .logoutSuccessHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                }))
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

    /**
     * 与默认Order(100)冲突
     */
    @Configuration
    @Order(99)
    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/other/hello").authorizeRequests()
                    .anyRequest().hasRole("other");
        }
    }
}
