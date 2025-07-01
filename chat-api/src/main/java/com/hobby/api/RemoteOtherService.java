package com.hobby.api;

import com.hobby.core.config.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "other-server", configuration = OpenFeignConfig.class)
public interface RemoteOtherService {

    @GetMapping("/others")
    public String getOthers();
}
