package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/3 22:13
 */
@RestController
public class HelloController {
    @Autowired
    MethodService methodService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    @GetMapping("/dba/hello")
    public String dba() {
        return "dba";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }

    @GetMapping("/other/hello")
    public String other() {
        return "other";
    }

    @GetMapping("/helloadmin")
    public String helloadmin(){
        return methodService.admin();
    }

    @GetMapping("/hellodba")
    public String hellodba(){
        return methodService.dba();
    }

    @GetMapping("/hellouser")
    public String hellouser(){
        return methodService.user();
    }
}
