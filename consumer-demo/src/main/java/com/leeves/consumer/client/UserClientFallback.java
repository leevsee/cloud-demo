package com.leeves.consumer.client;

import com.leeves.consumer.entity.User;

import org.springframework.stereotype.Component;

/**
 * @description TODO
 * @package com.leeves.consumer.client
 * @author Leeves
 * @date 2018/12/25
 */

@Component
public class UserClientFallback implements UserClient {

    @Override
    public User getUserInfoById(Long id) {
        User user = new User();
        user.setName("用户有误！");
        return user;
    }

}
