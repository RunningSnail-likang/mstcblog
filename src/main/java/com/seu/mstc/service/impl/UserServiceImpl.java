package com.seu.mstc.service.impl;

import com.seu.mstc.dao.UserDao;
import com.seu.mstc.jedis.JedisClient;
import com.seu.mstc.model.User;
import com.seu.mstc.result.ResultInfo;
import com.seu.mstc.service.UserService;
import com.seu.mstc.utils.Md5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by hys on 2018/4/30.
 */
@Service
public class UserServiceImpl implements UserService {


    //session 的过期时间
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Autowired
    UserDao userDao;

    @Autowired
    private JedisClient jedisClient;


    //邮箱重复性检查
    @Override
    public ResultInfo checkData(String email) {
        User user=null;
        user=userDao.selectByEmail(email);
        if(user==null){
            return ResultInfo.ok(false);
        }
        return ResultInfo.ok(true);
    }

    //用户注册
    @Override
    public ResultInfo register(String email, String password,String token) {
        if(StringUtils.isBlank(email)|| StringUtils.isBlank(password))
            return ResultInfo.build(400, "用户数据不完整，注册失败");

        User user=userDao.selectByEmail(email);
        if(user!=null){
            return ResultInfo.build(400,"此邮箱已经被注册");
        }

        Date date=new Date();
        user=new User();
        user.setNickname(email);
        user.setHometown("江苏省 南京市");
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));//随机生成一段盐存入数据库
        user.setEmail(email);
        user.setPassword(Md5Util.MD5(password + user.getSalt()));//存入密码加盐后的加密密文
        user.setRegisterTime(date);
        user.setToken(token);
        userDao.addUser(user);

        return ResultInfo.ok(user.getId());
    }



    //登录
    @Override
    public ResultInfo login(String email, String password) {
        User user=null;
        user=userDao.selectByEmail(email);

        if(user==null){
            return ResultInfo.build(400,"用户名或密码错误！");
        }
        if(!Md5Util.MD5(password+user.getSalt()).equals(user.getPassword())){
            return ResultInfo.build(400,"用户名或密码错误！");
        }

        return ResultInfo.ok();
    }

    @Override
    public ResultInfo getUserPhoto(String username, int type) {
        return null;
    }

    @Override
    public ResultInfo updateUserInfo(User user, String token) {
        return null;
    }

    //根据Token获取个人信息
    @Override
    public ResultInfo getUserByToken(String token) {
        return null;
    }

    @Override
    public ResultInfo getUserSettingByUserId(Integer userId) {
        return null;
    }

    //退出登录
    @Override
    public ResultInfo sinOut(String token) {
        return null;
    }

    //更新密码
    @Override
    public ResultInfo updatePasswordById(Integer id, String password) {
        return null;
    }


    //检查密码的正确性
    @Override
    public ResultInfo checkPasswordById(Integer id, String password) {
        return null;
    }

    //更新邮箱
    @Override
    public ResultInfo updateEmail(Integer id, String password, String token) {
        return null;
    }

    @Override
    public ResultInfo updateBackgroundUrlById(User user, String token) {
        return null;
    }

    //更新头像
    @Override
    public ResultInfo updateHeadUrlById(User user, String token) {
        return null;
    }

    @Override
    public ResultInfo getUserInfoByUserId(Integer userId) {
        return null;
    }
}
