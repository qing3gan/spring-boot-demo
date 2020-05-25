package com.enterprise.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * javax validation: 数据校验（javax.validation.constraints）
 *
 * @author agony
 * @date 2020/5/25 22:14
 */
@Getter
@Setter
public class User {
    @Size(min = 5, max = 10, message = "{user.name.size}", groups = ValidationGroup1.class)
    private String name;

    @NotNull(message = "{user.address.notnull}", groups = ValidationGroup2.class)
    private String address;

    @DecimalMin(value = "1", message = "{user.age.size}")
    @DecimalMax(value = "200", message = "{user.age.size}")
    private Integer age;

    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}", groups = {ValidationGroup1.class, ValidationGroup2.class})
    private String email;
}
