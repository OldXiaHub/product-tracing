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
    public User login(String nickName, String password) {
        User user= userDaoByZhangR.login(nickName,password);
        return user;
    }

//    /**
//     * autnor:zhangrui
//     * time:2019/8/20-17:27
//     * 前台用户注册不要了？
//     */
//    @Override
//    public void register(User user) {
//        //用 MD5生成用户id
//        user.setUserId(SecurityUtl.getMd5String("xiazhongqiang"));
//        userDaoByZhangR.userRegister(user);
//    }

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
    @Override
    public User getUserInfo(String nickName) {
        User user = userDaoByZhangR.getUserInfo(nickName);
        return null;
    }

    /**
     * 添加用户个人信息
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    @Override
    public int addUserInfo(User user) {
        int i = userDaoByZhangR.addUserInfo(user);
        return i;
    }

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    @Override
    public List<Complain> userComplain(String nickName) {
        List <Complain> list = userDaoByZhangR.userComplain(nickName);
        return list;
    }


}
