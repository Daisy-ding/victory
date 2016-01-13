package com.alva.redis.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alva.redis.dao.UserDao;
import com.alva.redis.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void addUser(String userName, String userPwd) {

        User user = new User(userName,userPwd);
        listOps.leftPush(userName, JSONObject.toJSONString(user));
        List<String> ll= listOps.range(userName,0,-1);
        System.out.println("ll.size : "+ll.size());
        for(int i=0;i<ll.size();i++){
            User u =(User)JSONObject.parseObject(ll.get(i),User.class);
            System.out.println("user.name : "+u.getName());
        }

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

    @Override
    public void addUserTransactional(final String myKey, final User myUser) {

        SessionCallback<User> sessionCallback = new SessionCallback<User>() {
            @Override
            public User execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                //事务,将多个命令排队执行.
                String key = myKey + ":" + myUser.getName();
                operations.opsForHash().put(key, "1", JSONObject.toJSONString(myUser));
                operations.expire(key, 6, TimeUnit.SECONDS);
                BoundValueOperations<String, String> oper = operations.boundValueOps(key);
                oper.set(myUser.getPwd());
                oper.expire(5, TimeUnit.SECONDS);
                oper.set("second");//这里再执行一次

                operations.exec();
                System.out.println(" after  addUserTx ");
                User  u = JSONObject.parseObject(operations.opsForHash().get(key, "1").toString(), User.class);
                System.out.println("user "+u.getName());
                return myUser;
            }
        };
        jedisTemplate.execute(sessionCallback);
    }

}

