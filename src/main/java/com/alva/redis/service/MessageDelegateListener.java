package com.alva.redis.service;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by alva on 16/1/7.
 */
public interface MessageDelegateListener {
    void handleMessage(String message);
    void handleMessage(Map message); void handleMessage(byte[] message);
    void handleMessage(Serializable message);
    // pass the channel/pattern as well
    void handleMessage(Serializable message, String channel);
}
