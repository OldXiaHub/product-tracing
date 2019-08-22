package org.taru.producttracing.service;

import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;

import java.util.List;

public interface UserServiceByZhangR {
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:20
     * 前台用户登录
     */
    public User login(String nickName, String password);

//    /**
//     * autnor:zhangrui
//     * time:2019/8/20-17:26
//     * 前台用户注册
//     */
//    public void register(User user);

    /**
     * 添加用户个人信息
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    public int addUserInfo(User user);

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
    public User getUserInfo(String nickName);

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    public List<Complain> userComplain(String nickName);
}
