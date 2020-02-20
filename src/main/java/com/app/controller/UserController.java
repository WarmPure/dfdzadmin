package com.app.controller;

import com.app.entity.Login;
import com.app.entity.ResultBean;
import com.app.entity.User;
import com.app.service.LoginService;
import com.app.service.UserService;
import com.app.tool.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

//    method = RequestMethod.POST
    @CrossOrigin
    @RequestMapping(value = "userLogin")
    public ResultBean<Login> userLogin(String username, String password) {

        ResultBean<Login> resultBean = new ResultBean<>();

        User user = userService.getUserInfo(username, password);

        if (null != user) {
            Login login = new Login();
            login.setUserId(user.getId());
            login.setNickName(user.getNickName());
            login.setStatus(1);
            login.setUserName(user.getUserName());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            login.setTime(df.format(new Date())); // new Date()为获取当前系统时间
            login.setToken(TokenProccessor.getInstance().makeToken());

            boolean insertLogin = loginService.insertLogin(login);

            if (insertLogin) {
                resultBean.setStatus("200");
                resultBean.setMsg("success");
                resultBean.setData(login);
            } else {
                resultBean.setStatus("500");
                resultBean.setMsg("用户登陆失败");
            }
        } else {
            resultBean.setStatus("500");
            resultBean.setMsg("用户名或密码不正确");
        }

        return resultBean;
    }

}
