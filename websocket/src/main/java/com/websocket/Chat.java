package com.websocket;

import lombok.Getter;
import lombok.Setter;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/17 23:09
 */
@Getter
@Setter
public class Chat {
    private String to;
    private String from;
    private String content;
}
