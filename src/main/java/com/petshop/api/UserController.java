package com.petshop.api;

import com.petshop.domain.ResultInfo;
import com.petshop.domain.User;
import com.petshop.mapper.UserMapper;
import com.petshop.utils.Constants;

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
    public ResultInfo<User> getUserInfo(@PathVariable("id") int userId) {
        ResultInfo<User> resultInfo = new ResultInfo<User>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            User data = userMapper.findUserById(userId);
            resultInfo.setData(data);
            return resultInfo;
        } catch (Exception e) {
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }

    @RequestMapping(value = "/user/add", method = POST)
    public ResultInfo<User> addUser(User user) {
        ResultInfo<User> resultInfo = new ResultInfo<User>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            userMapper.insertUser(user);
            return resultInfo;
        } catch (Exception e) {
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }

    @RequestMapping(value = "/user/{id}/delete", method = POST)
    public ResultInfo<User> deleteUser(@PathVariable("id") int userId) {
        ResultInfo<User> resultInfo = new ResultInfo<User>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try{
            userMapper.deleteUserById(userId);
            return resultInfo;
        } catch(Exception e) +{
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }

    @RequestMapping(value = "user/update", method = POST)
    public ResultInfo<User> updateUser(User user) {
        ResultInfo<User> resultInfo = new ResultInfo<User>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            userMapper.updateUser(user);
            return resultInfo;
        } catch (Exception e) {
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }
}
