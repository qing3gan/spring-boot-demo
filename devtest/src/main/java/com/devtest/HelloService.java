package com.devtest;

import org.springframework.stereotype.Service;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/23 22:01
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
