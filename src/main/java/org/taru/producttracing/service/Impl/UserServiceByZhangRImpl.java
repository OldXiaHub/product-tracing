package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.UserDaoByZhangR;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.util.StringUtil;

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
    /**
     * autnor:zhangrui
     * time:2019/8/20-17:27
     * 前台用户注册
     */

    @Override
    public int register(User user) {
        //用 MD5生成用户id
        int i ;
//        long k=System.currentTimeMillis();
//        String j=StringUtil.valueof(k);
//        user.setOpenId(SecurityUtl.getMd5String(j));
        i = userDaoByZhangR.userRegister(user);
        return i;
    }

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
    @Override
    public User getUserInfo(String openId) {
        User user = userDaoByZhangR.getUserInfo(openId);
        return user;
    }

    /**
     * 添加用户个人信息
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    public int addUserInfo(User nickName){
        int i = userDaoByZhangR.addUserInfo(nickName);
        return i;
    }

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */

    @Override
    public List<Complain> userComplain(String openId) {
        List <Complain> list = userDaoByZhangR.userComplain(openId);
        return list;
    }

    /**
     * 用户主动投诉
     * author:zhangrui
     * time:2019/8/22-22:10
     */
    @Override
    public int complain(Complain complain) {
        int i=0;
        i = userDaoByZhangR.complain(complain);
        return i;
    }
}
