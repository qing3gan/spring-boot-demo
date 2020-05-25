package com.enterprise.swagger2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/24 23:28
 */
@Getter
@Setter
@ToString
@ApiModel(value = "用户实体类", description = "用户信息描述类")
public class User {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户地址")
    private String address;
}
