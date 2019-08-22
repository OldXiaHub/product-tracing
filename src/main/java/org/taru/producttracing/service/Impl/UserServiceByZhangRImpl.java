package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.UserDaoByZhangR;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;

import java.util.List;


@Service
public class UserServiceByZhangRImpl implements UserServiceByZhangR {
@Autowired
UserDaoByZhangR userDaoByZhangR;
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:20
     * 前台用户登录
     */
    @Override
    public User login(String username, String password) {
        User user= userDaoByZhangR.login(username,password);
        return user;
    }

    @Override
    public int addUserInfo(User user) {
        return 0;
    }

    @Override
    public User getUserInfo(String nickName) {
        return null;
    }

    @Override
    public List<Complain> userComplain(String nickName) {
        return null;
    }

    /**
     * autnor:zhangrui
     * time:2019/8/20-17:27
     * 前台用户注册
     */
//    @Override
//    public void register(User user) {
//        //用 MD5生成用户id
//        user.setOpenId(SecurityUtl.getMd5String("xiazhongqiang"));
//        userDaoByZhangR.userRegister(user);
//    }

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
}
