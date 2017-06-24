package com.petshop.api;

import com.petshop.domain.User;
import com.petshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by challenger on 23/6/2017.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user/{id}", method = GET)
    public User getUserInfo(@PathVariable("id") int userId) {
        return userMapper.findUserById(userId);
    }

    @RequestMapping(value = "/user/add", method = POST)
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @RequestMapping(value = "/user/{id}/delete", method = POST)
    public void deleteUser(@PathVariable("id") int userId) {
        userMapper.deleteUserById(userId);
    }

    @RequestMapping(value = "user/update", method = POST)
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
