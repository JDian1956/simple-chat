package com.hobby.api;

import com.hobby.core.config.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "notify-server", configuration = OpenFeignConfig.class)
public interface RemoteNotifyService {

    @GetMapping("/notify/test")
    public String getNotify();
}
