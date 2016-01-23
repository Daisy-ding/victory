package com.alva.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by alva on 16/1/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class MessagePubSubTest {
    @Resource
    private MessagePub messagePub;
    @Resource
    private MessageSub messageSub;

    @Autowired
    private RedisMessageListenerContainer redisContainer;

    @Test
    public void testOnPublish() throws Exception {
        String key = "dingqi";
        String value = "dingqi";
        for(int i=0;i<5;i++){
            messagePub.onPublish(key,value+String.valueOf(i));
        }

        Integer[] values = new Integer[]{21341,123123,12323};
        messagePub.onPublish("test", "1222");  //发布一个String消息
    }

    @Test
    public void testOnSub() throws InterruptedException {

        messageSub.onCommonSub("test");

       /* while (true) {
            if (redisContainer.isRunning()) {
                System.out
                        .println("RedisMessageListenerContainer is running..");
            }
            Thread.sleep(5000);
        }*/
    }


}

