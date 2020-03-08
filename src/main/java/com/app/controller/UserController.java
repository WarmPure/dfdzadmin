package com.app.controller;

import com.app.entity.Login;
import com.app.entity.ResultBean;
import com.app.entity.User;
import com.app.service.LoginService;
import com.app.service.UserService;
import com.app.tool.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    //    method = RequestMethod.POST
    @RequestMapping(value = "userLogin")
    public ResultBean<Login> userLogin(@RequestBody Map<String,Object> reqMap) {

        String username = reqMap.get("username").toString();
        String password = reqMap.get("password").toString();

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
                resultBean.setStatus(200);
                resultBean.setMsg("success");
                resultBean.setData(login);
            } else {
                resultBean.setStatus(500);
                resultBean.setMsg("用户登陆失败");
            }
        } else {
            resultBean.setStatus(500);
            resultBean.setMsg("用户名或密码不正确");
        }

        return resultBean;
    }

}
