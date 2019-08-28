package org.taru.producttracing.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.FoodManageDao1;
import org.taru.producttracing.dao.UserDaoByZhangR;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public int register(@Param("openId") String openId, @Param("nickName") String nickName, @Param("userAddress")  String userAddress, @Param("avatarUrl") String avatarUrl) {
        //用 MD5生成用户id
        int i ;
//        long k=System.currentTimeMillis();
//        String j=StringUtil.valueof(k);
//        user.setOpenId(SecurityUtl.getMd5String(j));
        i = userDaoByZhangR.userRegister( openId,  nickName, userAddress,  avatarUrl);
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

//    /**
//     * 添加用户个人信息
//     * author:zhangrui
//     * time:2019/8/21-15:37
//     */
//    public int addUserInfo(User nickName){
//        int i = userDaoByZhangR.addUserInfo(nickName);
//        return i;
//    }

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
    public int complain(@Param("complainId")String complainId, @Param("complainName") String complainName,@Param("complainContent") String complainContent,@Param("complainUserId") String complainUserId,@Param("complainTime") String complainTime,@Param("complainUserTelphone") String complainUserTelphone,@Param("complainBatchBarcode") String complainBatchBarcode) {
        int i=0;
        Complain complain =new Complain();
        complainId =StringUtil.valueof(System.currentTimeMillis());
        complain.setComplainId(complainId);

        Date date = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        complainTime=ss.format(date);
        complain.setComplainTime(complainTime);

        i = userDaoByZhangR.complain(complainId,complainName,complainContent,complainUserId,complainTime,complainUserTelphone,complainBatchBarcode);
        return i;
    }

    /**
     * 查询所有用户信息
     * author：zhangrui
     * time:2019/8/83-21:29
     */
    public List<User> queryUser(){
        List<User> list=null;
        list=userDaoByZhangR.queryUser();
        return list;
    }

    /**
     * 根据id 查询批次
     * @param batchBarcode
     * @return
     */
    @Override
    public Batch  queryBatch(String batchBarcode) {
        return userDaoByZhangR.queryBatchById(batchBarcode);
    }
}
