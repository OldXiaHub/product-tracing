package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;

import java.util.List;

@Mapper
@Component
public interface UserDaoByZhangR {
    /**
     * autnor:zhangrui
     * time:2019/8/20-11:11
     * 前台用户登录
     */
    public User login(@Param("nickName") String nickName, @Param("password") String password);

//    /**
//     *autnor:zhangrui
//     * time:2019/8/20/16:52
//     * 前台用户注册
//     */
//    public void userRegister(User user);

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
    public User getUserInfo(String nickName);

    /**
     * 添加用户个人信息
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    public int addUserInfo(User nickName);

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    public List<Complain> userComplain(String nickName);
}
