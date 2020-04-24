package com.devtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/23 23:01
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }

    @PostMapping("/book")
    public String addBook(@RequestBody Book book) {
        return book.toString();
    }
}