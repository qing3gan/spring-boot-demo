package com.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * CustomAccessDecisionManager: 访问权限匹配（角色匹配）
 *
 * @author agony
 * @date 2020/5/11 22:51
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (ConfigAttribute configAttribute : collection) {
            if ("ROLE_login".equals(configAttribute.getAttribute())
                    && authentication instanceof UsernamePasswordAuthenticationToken) {
                return;
            }
            for (GrantedAuthority authority : authorities) {
                if (configAttribute.getAttribute().equals(authority.getAuthority())) {
                    return;
                }
            }
            throw new AccessDeniedException("权限不足");
        }
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
