package com.agony.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 自定义Error控制器
 *
 * @author agony
 * @date 2020/2/12 23:31
 */
@Controller
public class MyErrorController extends BasicErrorController {
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
        //Controller: 扫描注入
        //Autowired: 自动注入
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        errorAttributes.put("page", "myErrorPage");
        errorAttributes.put("custommsg", "出错啦！");
        HttpStatus status = getStatus(request);
        return new ModelAndView("myErrorPage", errorAttributes, status);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        errorAttributes.put("page", "myErrorPage");
        errorAttributes.put("custommsg", "出错啦！");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(errorAttributes, status);
    }
}
