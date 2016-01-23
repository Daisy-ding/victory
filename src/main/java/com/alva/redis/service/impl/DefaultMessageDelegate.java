package com.alva.redis.service.impl;

import com.alva.redis.service.MessageDelegateListener;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by alva on 16/1/7.
 */
public class DefaultMessageDelegate implements MessageDelegateListener {
    @Override
    public void handleMessage(String message) {

    }

    @Override
    public void handleMessage(Map message) {

    }

    @Override
    public void handleMessage(byte[] message) {

    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println("aHa, in handleMessage----");
        if(message == null){
            System.out.println("null");
            System.out.println(Arrays.toString((Object[]) message));
        } else if(message instanceof List<?>) {
            System.out.println(message);
        } else if(message instanceof Map<? , ?>) {
            System.out.println(message);
        } else {
            System.out.println(ToStringBuilder.reflectionToString(message));
        }

    }

    @Override
    public void handleMessage(Serializable message, String channel) {

    }
}
