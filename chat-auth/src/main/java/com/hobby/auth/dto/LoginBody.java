package com.hobby.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Harris
 */
@Data
public class LoginBody {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    private String code;
    @NotBlank(message = "序列号不能为空")
    private String uuid;
}
