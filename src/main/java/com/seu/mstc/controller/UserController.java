package com.seu.mstc.controller;


import com.alibaba.fastjson.JSONObject;
import com.seu.mstc.dao.UserDao;
import com.seu.mstc.model.User;
import com.seu.mstc.result.ResultInfo;
import com.seu.mstc.service.UserService;
import com.seu.mstc.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by lk on 2018/4/30.
 */

@RestController
@RequestMapping(value="/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailUtils emailUtils;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    /**
     * 用户名和邮箱重复性检查
     * 数据库中已有该用户名或者邮箱则返回true，否则返货false
     * @param jsonObject
     * @return
     */
    @RequestMapping(value="/check",method = RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultInfo checkData(@RequestBody JSONObject jsonObject){
        ResultInfo result=null;
        String email=jsonObject.getString("email");
        try {
            result = userService.checkData(email);
        } catch (Exception e) {
            logger.error("重复性检查出现异常"+e.getMessage());
            e.printStackTrace();
            result=ResultInfo.build(500, "检查时服务器发生错误！");
        }
        return result;
    }



    //邮箱注册
    @RequestMapping(value="/registeremail",method = RequestMethod.POST)
    public ResultInfo register(@RequestBody JSONObject jsonObject,HttpServletResponse response){
        String email=jsonObject.getString("email");
        String password=jsonObject.getString("password");

        //没有加是否需要记住登陆状态判断，直接给定一个有效期了
        String token= UUID.randomUUID().toString();
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(3600 * 24 * 5);//5天的有效期
        response.addCookie(cookie);

        return userService.register(email,password,token);
    }

    //注册时发送验证码
    /**
     * 发送验证码
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/captcha",method = RequestMethod.POST)
    public ResultInfo sendCaptcha(@RequestBody JSONObject jsonObject){
        ResultInfo result=null;
        String code=jsonObject.getString("code");
        String email=jsonObject.getString("email");
        try {
            result = emailUtils.sendCaptcha(code, email);
        } catch (Exception e) {
            logger.error("发送验证码时服务器发生异常"+e.getMessage());
            e.printStackTrace();
            result=ResultInfo.build(500, "发送验证码时服务器发生错误！");
        }
        return result;
    }

    //登录
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResultInfo login(@RequestBody JSONObject jsonObject,HttpServletResponse response){
        ResultInfo result=null;
        String password=jsonObject.getString("password");
        String email=jsonObject.getString("email");
        Boolean rememberme=jsonObject.getBoolean("rememberme");
        User user=userDao.selectByEmail(email);
        result=userService.login(email,password);

        if(result.getStatus()==200){
            Cookie cookie=new Cookie("token",user.getToken());
            cookie.setPath("/");
            if(rememberme){
                cookie.setMaxAge(3600*24*5);//有效期5天3600*24*5
            }
            response.addCookie(cookie);
        }

        return result;
    }

}
