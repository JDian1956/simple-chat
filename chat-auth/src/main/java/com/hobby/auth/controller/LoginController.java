package com.hobby.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hobby.auth.dto.LoginBody;
import com.hobby.auth.dto.SysUserDto;
import com.hobby.auth.entity.SysUser;
import com.hobby.auth.service.SysUserService;
import com.hobby.core.util.ResponseResult;
import com.hobby.datasource.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/register")
    public ResponseResult<Object> register(@Validated @RequestBody SysUser sysUser) {
        return ResponseResult.success(sysUserService.registerUser(sysUser));
    }

    @GetMapping("/list/{current}/{size}")
    public ResponseResult<PageResponse<SysUserDto>> queryList(@PathVariable("current") int current, @PathVariable("size") int size) {
        return ResponseResult.success(sysUserService.queryList(current, size));
    }
}
