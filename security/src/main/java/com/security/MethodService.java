package com.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/4 17:46
 */
@Service
public class MethodService {
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "hello admin";
    }

    @PreAuthorize("hasRole('admin') and hasRole('DBA')")
    public String dba() {
        return "hello dba";
    }

    @PostAuthorize("hasAnyRole('admin','dba','user')")
    public String user() {
        return "hello user";
    }
}
