package com.alva.redis.service.impl;

import com.alva.redis.service.MessagePub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by alva on 16/1/7.
 */
@Service
public class MessagePubImpl implements MessagePub {

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;


    @Override
    public void onPublish(String key,String value) {

        jedisTemplate.convertAndSend(key,value);
    }
}
