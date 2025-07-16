package com.hobby.api;

import com.hobby.core.util.ResponseResult;
import com.hobby.core.config.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@FeignClient(name = "auth-server", configuration = OpenFeignConfig.class)
public interface RemoteAuthService {

    @GetMapping("/auth/test")
    public <T> ResponseResult<T> getDemo();
}
