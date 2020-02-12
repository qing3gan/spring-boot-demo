package com.agony.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice: GlobalController
 *
 * @author agony
 * @date 2020/2/10 21:56
 */
@ControllerAdvice
public class GlobalController {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e, HttpServletResponse response) {
        //ExceptionHandler: 全局异常捕获
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "上传文件大小超出限制！");
        mv.setViewName("error");
        return mv;
    }

    @ModelAttribute(value = "info")
    public Map<String, String> userInfo() {
        //ModelAttribute: 模型属性
        Map<String, String> map = new HashMap<>();
        map.put("username", "罗贯中");
        map.put("gender", "男");
        return map;
    }

    @InitBinder("a")
    public void init(WebDataBinder binder) {
        //InitBinder: 数据编辑器（前后端）
        binder.setFieldDefaultPrefix("a.");
    }

    @InitBinder("b")
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }
}
