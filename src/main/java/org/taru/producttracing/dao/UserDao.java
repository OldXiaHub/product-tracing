package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.producttracing.pojo.User;

@Mapper
@Component
public interface UserDao {
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:11
     * 前台用户登录
     */
    public User login(@Param("username") String username, @Param("password") String password);

    /**
     *autnor:zhangrui
     * time:2019/8/20/16:52
     * 前台用户注册
     */
    public void userRegister(User user);
}
