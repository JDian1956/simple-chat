package com.hobby.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "notify-server")
public interface RemoteNotifyService {

    @GetMapping("/notify")
    public String getNotify();
}
