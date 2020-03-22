package com.agony.controller;

import com.agony.entity.Author;
import com.agony.entity.Book;
import com.agony.entity.Hello;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * RestController = Rest(Representational State Transfer) + Controller + ResponseBody
 * GetMapping = RequestMapping(get)
 * Value: 注入值(${配置文件}，#{SpEL bean})
 *
 * @author agony
 * @date 2020/1/5 20:34
 */
@RestController
public class HelloController {
    private static final Log logger = LogFactory.getLog(HelloController.class);

    @Autowired
    private Hello hello;

    @GetMapping("/hello")
    public String hello() {
        return hello.sayHello("hello");
    }

    @GetMapping("/info")
    public void info(Model model) {
        Map<String, Object> map = model.asMap();
        map.entrySet().forEach(logger::info);
    }

    @GetMapping("/init")
    public String init(@ModelAttribute("a") Author author, @ModelAttribute("b") Book book) {
        return author.toString() + "\n" + book.toString();
    }

    @GetMapping("/byzero")
    public String byzero() {
        // 错误页面优先级: 响应码 -> 通配符 -> 动态 -> 静态
        int i = 1 / 0;
        return "byzero";
    }

    @Value("${server.port}")
    private String port;

    @PostMapping("/save")
    public String saveName(String name, HttpSession session) {
        session.setAttribute("name", name);
        return port + ": save " + name;
    }

    @GetMapping("/get")
    public String getName(String name, HttpSession session) {
        return port + ": get" + session.getAttribute(name);
    }
}
