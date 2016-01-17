package com.alva.redis.dao;

import com.alva.redis.entry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alva on 16/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestUserDaoImpl {
    @Autowired
    private RedisTemplate jedisTemplate;

    @Resource(name="userDao")
    private UserDao userDao;
    @Test
    public void putAndGet() {
        jedisTemplate.opsForHash().put("test", "name", "dq");
        Object name = jedisTemplate.opsForHash().get("test", "name");
        System.out.println(name);
        jedisTemplate.opsForList().leftPush("ll", "2");
        jedisTemplate.opsForList().leftPush("ll", "3");
        jedisTemplate.opsForList().leftPush("ll", "0");
        System.out.println(jedisTemplate.opsForList().range("ll", 0, -1));

        ValueOperations<String, User> valueOper = jedisTemplate.opsForValue();
        User user = new User("2","dingqi", "123");
        valueOper.set("user:1", user);
        System.out.println(valueOper.get("user:1").getName());

    }
    @Test
    public void testAddUser(){

        userDao.addUser("3","testName", "testPwd");
    }

    @Test
    public void testCallBack(){
        userDao.useCallback();
    }

//    @Test
//    public void testAddTx(){
//        User user = new User("dingqi","0000");
//        userDao.addUserTransactional("user",user);

//    }
}

