package com.alva.redis.dao;

import com.alva.redis.entry.User;

/**
 * Created by alva on 16/1/5.
 */
public  interface UserDao {

    /**
     * 增加user
     * @param userName
     * @param userPwd
     */
    public void addUser(String userName, String userPwd);

    /**
     * callBack方法
     */
    public void useCallback();

    /**
     *采用事务的方式增加
     */
    public void addUserTransactional(String key,User user);

}
