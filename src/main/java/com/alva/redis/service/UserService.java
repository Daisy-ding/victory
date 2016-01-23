package com.alva.redis.service;

import com.alva.redis.entry.User;

/**
 * Created by alva on 16/1/17.
 */
public interface UserService {

    public User getUserById(String userId);

}
