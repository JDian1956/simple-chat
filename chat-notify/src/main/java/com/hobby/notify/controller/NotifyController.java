package com.hobby.notify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harris
 */
@RestController
public class NotifyController {

    @GetMapping("/test")
    public String getNotify() {
        return "Notify";
    }
}
