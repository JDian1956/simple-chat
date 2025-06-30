package com.hobby.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "other-server")
public interface RemoteOtherService {

    @GetMapping("/others")
    public String getOthers();
}
