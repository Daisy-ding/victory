package com.alva.redis.dao;

import com.alva.redis.entry.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by alva on 16/1/5.
 */
public  interface UserDao {

    /**
     * 增加user
     * @param userName
     * @param userPwd
     */
    public void addUser(String id,String userName, String userPwd);

    /**
     * callBack方法
     */
    public void useCallback();

    /**
     *采用事务的方式增加
     */
    public void addUserTransactional(String id,String key,User user);



}
