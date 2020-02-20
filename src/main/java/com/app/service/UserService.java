package com.app.service;


import com.app.entity.User;
import com.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserInfo(String phone, String password){
        return userMapper.getUser(phone, password);
    }

    public User getUser(int userId){
        return userMapper.getUserById(userId);
    }
}
