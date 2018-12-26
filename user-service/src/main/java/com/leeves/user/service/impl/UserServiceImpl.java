package com.leeves.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leeves.user.entity.User;
import com.leeves.user.mapper.UserMapper;
import com.leeves.user.service.IUserService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Leeves
 * @since 2018-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
