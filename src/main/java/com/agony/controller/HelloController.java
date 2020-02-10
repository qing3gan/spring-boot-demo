package com.agony.controller;

import com.agony.bean.Author;
import com.agony.bean.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * RestController = Controller + RequestMapping
 * GetMapping = RequestMapping(get)
 *
 * @author agony
 * @date 2020/1/5 20:34
 */
@RestController
public class HelloController {
    private static final Log logger = LogFactory.getLog(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        return "hello";
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
}
