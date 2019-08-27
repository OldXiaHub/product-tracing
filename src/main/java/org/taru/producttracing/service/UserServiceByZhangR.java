package org.taru.producttracing.service;

import org.apache.ibatis.annotations.Param;
import org.taru.producttracing.pojo.Batch;
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

    /**
     * autnor:zhangrui
     * time:2019/8/20-17:26
     * 前台用户注册
     */
    public int register(@Param("openId") String openId, @Param("nickName") String nickName, @Param("userAddress")  String userAddress, @Param("avatarUrl") String avatarUrl);

//    /**
//     * 添加用户个人信息
//     * author:zhangrui
//     * time:2019/8/21-15:37
//     */
//    public int addUserInfo(User user);

    /**
     * 用户个人信息获取
     *author:zhangrui
     * time：2019/08/21-14:17
     */
    public User getUserInfo(String openId);

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    public List<Complain> userComplain(String openId);

    /**
     * 用户主动投诉
     * author:zhangrui
     * time:2019/8/22-21:10
     */
    public int complain(@Param("complainId")String complainId,@Param("complainName") String complainName,@Param("complainContent") String complainContent,@Param("complainUserId") String complainUserId,@Param("complainTime") String complainTime,@Param("complainUserTelphone") String complainUserTelphone,@Param("complainBatchBarcode") String complainBatchBarcode);

    /**
     * 查询所有用户信息
     * author：zhangrui
     * time:2019/8/83-21:29
     */
    public List<User> queryUser();

    /**
     * id查询批次
     */
    public Batch queryBatch(String batchBarcode);
}
