//package com.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * AuthorizationServerConfigurerAdapter: 授权服务器配置
// *
// * @author agony
// * @date 2020/5/12 22:42
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("password")
//                .authorizedGrantTypes("password" , "refresh_token")
//                .accessTokenValiditySeconds(1800)
//                .resourceIds("rid")
//                .scopes("all")
//                .secret("$2a$10$pt.tMv6BddM6K8uV27SIquPc0F6EdgOPXC2T54.gCmGhVjg9A7bi.");
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients();
//    }
//}
