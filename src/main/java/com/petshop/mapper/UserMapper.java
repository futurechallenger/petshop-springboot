package com.petshop.mapper;

import com.petshop.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by challenger on 23/6/2017.
 */
public interface UserMapper {
    //    @Insert("INSERT INTO user (username, password) values (#{username}, #{password})")
    void insertUser(@Param("user") User user);

    //    @Select("SELECT * FROM user WHERE userId = #{userId}")
    User findUserById(@Param("userId") Integer userId);

    //    @Select("SELECT * FROM user")
    List<User> findAllUsers(Map<String, String> map);

    //    @Delete("UPDATE user SET deleted = 1 WHERE userId = #{userId}")
    void deleteUserById(@Param("userId") int userId);

    void updateUser(@Param("user") User user);
}
