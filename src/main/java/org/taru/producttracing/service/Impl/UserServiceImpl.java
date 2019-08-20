package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.UserDao;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserService;
import org.taru.producttracing.util.SecurityUtl;


@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserDao userDao;
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:20
     * 前台用户登录
     */
    @Override
    public User login(String username, String password) {
        User user=userDao.login(username,password);
        return user;
    }

    /**
     * autnor:zhangrui
     * time:2019/8/20-17:27
     * 前台用户注册
     */
    @Override
    public void register(User user) {
        //用 MD5生成用户id
        user.setUserId(SecurityUtl.getMd5String("xiazhongqiang"));
        userDao.userRegister(user);
    }
}
