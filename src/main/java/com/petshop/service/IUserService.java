package com.petshop.service;

import com.petshop.domain.User;
import java.util.List;
import java.util.Map;

public interface IUserService {
    User getUserById(long userId);

    List<User> getUserByCondition(Map conditon);
    
    int deleteUser(long userId);

    int updateUser(User user);

    int createUser(User user);
}