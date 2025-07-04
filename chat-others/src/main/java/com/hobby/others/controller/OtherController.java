package com.hobby.others.controller;

import com.hobby.api.RemoteAuthService;
import com.hobby.api.RemoteNotifyService;
import com.hobby.core.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harris
 */
@RestController
public class OtherController {

    private final RemoteNotifyService remoteNotifyService;
    private final RemoteAuthService remoteAuthService;

    @Autowired
    public OtherController(RemoteNotifyService remoteNotifyService,
                           RemoteAuthService remoteAuthService) {
        this.remoteNotifyService = remoteNotifyService;
        this.remoteAuthService = remoteAuthService;
    }

    @GetMapping("/others")
    public String getOthers() {
        return "others";
    }

    @GetMapping("/notify")
    public String getNotify() {
        return remoteNotifyService.getNotify();
    }

    @GetMapping("/auth")
    public <T> ResponseResult<T> getAuth() {
        return remoteAuthService.getDemo();
    }
}
