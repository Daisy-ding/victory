package com.alva.redis.service;

/**
 * 消息发布类
 * Created by alva on 16/1/6.
 */
public interface MessagePub {

    /**
     * 发布信息
     */
    public void onPublish(String key,String value);
}
