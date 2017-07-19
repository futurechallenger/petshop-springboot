package com.petshop.service.impl;

import com.petshop.domain.User;
import com.petshop.mapper.PetMapper;
import com.petshop.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {
    @Autowired
    private PetMapper petMapper;

    public User getUserById(long userId){
        return petMapper.findPetById(userId);
    }

    List<User> getUserByCondition(Map<String, String> conditon) {
        return petMapper.find
    }
    
    int deleteUser(long userId);

    int updateUser(User user);

    int createUser(User user);
}