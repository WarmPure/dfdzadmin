package com.app.service;


import com.app.entity.Login;
import com.app.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    public boolean insertLogin(Login login){
        return loginMapper.insertLogin(login);
    }

    public String getUserId(String token){
        return loginMapper.selectId(token);
    }
}
