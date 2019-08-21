package org.taru.producttracing.service;

import org.taru.producttracing.pojo.User;

public interface UserServiceByZhangR {
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:20
     * 前台用户登录
     */
    public User login(String username, String password);

    /**
     * autnor:zhangrui
     * time:2019/8/20-17:26
     * 前台用户注册
     */
    public void register(User user);

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
}
