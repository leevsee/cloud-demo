package com.leeves.consumer.client;

import com.leeves.consumer.entity.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description feign
 * @package com.leeves.consumer.client
 * @author Leeves
 * @date 2018/12/25
 */

@FeignClient(value = "USER-SERVICE",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("user/{id}")
    public User getUserInfoById(@PathVariable("id") Long id);
}
