package com.hobby.others.controller;

import com.hobby.api.RemoteAuthService;
import com.hobby.api.RemoteNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harris
 */
@RestController
public class OtherController {

    @Autowired
    private RemoteNotifyService remoteNotifyService;
    @Autowired
    private RemoteAuthService remoteAuthService;

    @GetMapping("/others")
    public String getOthers() {
        return "others";
    }

    @GetMapping("/notify")
    public String getNotify() {
        return remoteNotifyService.getNotify();
    }

    @GetMapping("/auth")
    public String getAuth() {
        return remoteAuthService.getDemo();
    }
}
