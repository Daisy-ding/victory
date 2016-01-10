package com.alva.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by alva on 16/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
    public class TestMessageSub {
    @Resource
    private MessageSub messageSub;

    @Test
    public void testIsSub(){

      System.out.println(" is sub?" + messageSub.isSub("test"));
    }


}
