package com.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/18 23:43
 */
@Getter
@Setter
@ToString
public class Message implements Serializable {
    private String content;
    private Date date;
}
