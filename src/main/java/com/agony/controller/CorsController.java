package com.agony.controller;

import org.springframework.web.bind.annotation.*;

/**
 * CORS(Cross-Origin-Resource-Sharing)
 *
 * @author agony
 * @date 2020/2/13 22:15
 */
@RestController
@RequestMapping("/cors")
public class CorsController {
    @PostMapping("/")
    @CrossOrigin(value = "https://localhost:8082", maxAge = 1800, allowedHeaders = "*")
    public String add(String args) {
        return "add:" + args;
    }

    @DeleteMapping("/{args}")
    @CrossOrigin(value = "https://localhost:8082", maxAge = 1800, allowedHeaders = "*")
    public String delete(@PathVariable String args) {
        return "delete:" + args;
    }
}
