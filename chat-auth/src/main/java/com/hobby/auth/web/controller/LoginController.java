package com.hobby.auth.web.controller;

import com.hobby.auth.entity.LoginBody;
import com.hobby.auth.web.pojo.SysUser;
import com.hobby.auth.web.service.SysUserService;
import com.hobby.core.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Harris
 */
@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

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

    @GetMapping("/test")
    public ResponseResult<SysUser> getDemo() {
        SysUser admin = sysUserService.queryByUsername("admin");
        return ResponseResult.success(admin);
    }
}
