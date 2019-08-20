package org.taru.producttracing.service;

import org.taru.producttracing.pojo.User;

public interface UserService {
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
}
