package com.alva.redis.service.impl;

import com.alva.redis.service.MessageSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

/**
 * Created by alva on 16/1/6.
 */
@Service("messageSub")
public class MessageSubImpl  implements MessageSub {

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Autowired
    private MessageListenerAdapter messageListenerAdapter;


    @Override
    public void onCommonSub(String channel) {
        System.out.print("MessageSub --in");

        RedisConnection jc =  jedisTemplate.getConnectionFactory().getConnection();

        System.out.println(jc.isSubscribed());

        jc.subscribe(messageListenerAdapter, channel.getBytes());

        System.out.println(jc.isSubscribed());
    }
    @Override
    public boolean isSub(String channel) {
        System.out.print("MessageSub --in");

        RedisConnection jc =  jedisTemplate.getConnectionFactory().getConnection();

        return jc.isSubscribed();

    }

}
