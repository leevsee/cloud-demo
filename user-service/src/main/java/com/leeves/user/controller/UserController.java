package com.leeves.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leeves.user.entity.User;
import com.leeves.user.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Leeves
 * @since 2018-12-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Long id) throws InterruptedException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getId,id);
//        userQueryWrapper.eq("","");
        User user = userMapper.selectOne(userQueryWrapper);
        if (id % 2 == 0 ){
            Thread.sleep(2000);
        }
        return user;
    }
}
