package com.alva.redis.dao;

import com.alva.redis.entry.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by alva on 16/1/17.
 */
public interface UserMapper {
//    @Select("SELECT * FROM tb_user WHERE user_id = #{userId}")
//    User getUserById(@Param("userId") String userId);

    User getUserById(String userId);
}