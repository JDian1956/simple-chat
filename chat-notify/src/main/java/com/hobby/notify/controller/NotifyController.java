package com.hobby.notify.controller;

import com.hobby.core.util.ResponseResult;
import com.hobby.notify.entity.AccountEntity;
import com.hobby.notify.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harris
 */
@RequiredArgsConstructor
@RestController
public class NotifyController {

    private final AccountService accountService;

    @GetMapping("/test")
    public String getNotify() {
        return "Notify";
    }

    @PostMapping("/add")
    public ResponseResult<Object> addNotify(@RequestBody AccountEntity  entity){
        return ResponseResult.success(accountService.insert( entity));
    }
}
