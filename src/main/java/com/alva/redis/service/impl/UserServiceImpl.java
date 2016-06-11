package com.alva.redis.service.impl;

import com.alva.redis.dao.UserMapper;
import com.alva.redis.entry.User;
import com.alva.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by alva on 16/1/17.
 */
@Repository
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public User getUserById(String userId) {

        Object  o = jedisTemplate.boundHashOps(userId).get(userId);
        User u = userMapper.getUserById(userId);
        return u;
    }
}
