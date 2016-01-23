package com.alva.redis.service;

import java.util.concurrent.Executor;

/**
 * 消息订阅类
 * Created by alva on 16/1/6.
 */
public interface MessageSub {
    Executor e = new Executor() {
        @Override
        public void execute(Runnable command) {

        }
    };

    /**
     * 普通订阅模式
     */
    public void onCommonSub(String channel);

    public boolean isSub(String channel);

}
