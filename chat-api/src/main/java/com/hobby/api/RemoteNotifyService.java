package com.hobby.api;

import com.hobby.api.entity.AccountEntity;
import com.hobby.core.config.OpenFeignConfig;
import com.hobby.core.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Harris
 */
@FeignClient(name = "notify-server", configuration = OpenFeignConfig.class)
public interface RemoteNotifyService {

    @GetMapping("/notify/test")
    public String getNotify();

    @PostMapping("/notify/add")
    public <T> ResponseResult<T> addNotify(AccountEntity  entity);
}
