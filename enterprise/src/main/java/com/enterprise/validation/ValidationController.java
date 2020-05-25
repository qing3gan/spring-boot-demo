package com.enterprise.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Validated: spring context validation
 * BindingResult: 数据校验结果
 *
 * @author agony
 * @date 2020/5/25 22:25
 */
@RestController
public class ValidationController {
    @PostMapping("/validation")
    public List<String> validation(@Validated(ValidationGroup1.class) User user, BindingResult result) {
        List<String> errors = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errors.add(error.getDefaultMessage());
            }
        }
        return errors;
    }
}
