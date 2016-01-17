package com.alva.redis.service;

import com.alva.redis.entry.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by alva on 16/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestUserService {

    @Resource
    UserService userService;

    @Test
    public void  testGetUserById(){
        String userId ="1";
        User u = userService.getUserById(userId);
        System.out.println(u.getName());
        Assert.notNull(userService.getUserById(userId));
    }

}
