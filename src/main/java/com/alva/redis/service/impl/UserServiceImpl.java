package com.alva.redis.service.impl;

import com.alva.redis.dao.UserMapper;
import com.alva.redis.entry.User;
import com.alva.redis.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by alva on 16/1/17.
 */
@Repository
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        User u = userMapper.getUserById(userId);
        return u;
    }
}
