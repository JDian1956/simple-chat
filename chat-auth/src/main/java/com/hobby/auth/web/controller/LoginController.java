package com.hobby.auth.web.controller;

import com.hobby.auth.entity.LoginBody;
import com.hobby.core.pojo.ResponseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Harris
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseResult<LoginBody> login(@Validated @RequestBody LoginBody loginBody) {
        return ResponseResult.success(loginBody);
    }

    @GetMapping("/logout")
    public <T> ResponseResult<T> logout() {
        return ResponseResult.success();
    }

    @GetMapping("/getUserInfo")
    public <T> ResponseResult<T> getUserInfo() {
        return ResponseResult.success();
    }
}
