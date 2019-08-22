package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.vo.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
public class UserApiByZhang {
    @Autowired
    UserServiceByZhangR userServiceByZhangR;
    @Autowired
    RedisTemplate redisTemplate;

        /**前台用户登录
         * time:2019/8/20-11:31
         * author:zhangrui
         * @param nickName
         * @param password
         * @return
         */
        @RequestMapping(value = "/api/user/login")
        public JsonResult userLogin(String nickName, String password, HttpServletResponse response) {
            JsonResult result;
            User user = null;
            try {
                user = userServiceByZhangR.login(nickName, password);
                if (user != null) {
                    String  token_jSessionId = SecurityUtl.getMd5String(nickName);  //令牌
                    redisTemplate.opsForHash().put("loginUserKey",token_jSessionId,user.getOpenId());
                    result = new JsonResult("200", "登录成功", user);
                    Cookie cookie = new Cookie("token",token_jSessionId);
                    cookie.setPath("/");    //任何请求都要携带凭证
                    cookie.setMaxAge(60*60*60);
                    response.addCookie(cookie);
                } else if(nickName.equals("")||password.equals("")){
                    result = new JsonResult("405", "用户名密码不能为空", "");
                }else{
                    result = new JsonResult("404", "用户名密码错误", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new JsonResult("500", e.getMessage(), "");
            }
            return result;
        }
//    /**
//     * 前台用户注册
//     * author：zhangrui
//     * time：2019/8/20-17：40
//      */


    /**
     * 添加用户个人信息
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    @RequestMapping(value = "/api/user/adduserinfo" ,method = RequestMethod.POST)
    public JsonResult addUserInfo(User user){
        JsonResult result=null;
        int i=0;
        try{
            i=userServiceByZhangR.addUserInfo(user);
            if (i!=0){
                result = new JsonResult("200", "添加用户个人信息成功", i);
            }else {
                result = new JsonResult("404", "添加用户个人信息失败", i);
            }
        }catch(Exception e){
            e.printStackTrace();
            result = new JsonResult("500", e.getMessage(), "");
        }
        return result;
    }

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    @RequestMapping(value = "/api/user/complain")
    public JsonResult userComplain(String nickName){
        JsonResult result=null;
        List<Complain> list=null;
        try{
            list=userServiceByZhangR.userComplain(nickName);
            if (list!=null){
                result = new JsonResult("200", "查询本用户投诉记录成功", list);
            }else {
                result = new JsonResult("404", "查询本用户投诉记录失败", "");
            }
        }catch(Exception e){
            e.printStackTrace();
            result = new JsonResult("500", e.getMessage(), "");
        }
        return result;
    }
}
