package com.alva.redis.dao.impl;

import com.alva.redis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by alva on 16/1/5.
 */
@Repository("userDao")
public class UserDaoImpl implements  UserDao {

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "jedisTemplate")
    public ListOperations<String, String> listOps;

    public int addUser(String userName, String userPwd) {

        listOps.leftPush(userName, userPwd);
        return 1;
    }

    public void useCallback() {

        stringRedisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                System.out.println(size);
                // Can cast to StringRedisConnection if using a StringRedisTemplate
                ((StringRedisConnection) connection).set("newkey", "newValue");
                size = connection.dbSize();//size 增加1
                System.out.println(size);
                return size;
            }

        });

    }
}

