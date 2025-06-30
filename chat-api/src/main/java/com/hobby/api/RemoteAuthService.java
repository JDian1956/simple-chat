package com.hobby.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "auth-server")
public interface RemoteAuthService {

    @GetMapping("/test")
    public String getDemo();
}
