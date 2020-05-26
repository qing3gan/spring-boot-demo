package com.monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/26 21:17
 */
@RestController
public class MonitorController {
    @GetMapping("/monitor")
    public String monitor() {
        return "monitor";
    }
}
