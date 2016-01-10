package com.alva.redis.dao;

/**
 * Created by alva on 16/1/5.
 */
public  interface UserDao {

    /**
     * 增加user
     * @param userName
     * @param userPwd
     */
    public int addUser(String userName, String userPwd);

    public void useCallback();

}
