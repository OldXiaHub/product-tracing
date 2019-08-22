package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.vo.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
         * @param username
         * @param password
         * @return
         */
        @RequestMapping(value = "/api/user/login")
        public JsonResult userLogin(String username, String password, HttpServletResponse response) {
            JsonResult result;
            User user = null;
            try {
                user = userServiceByZhangR.login(username, password);
                if (user != null) {
                    String  token_jSessionId = SecurityUtl.getMd5String(username);  //令牌
                    redisTemplate.opsForHash().put("loginUserKey",token_jSessionId,user.getOpenId());
                    result = new JsonResult("200", "登录成功", user);
                    Cookie cookie = new Cookie("token",token_jSessionId);
                    cookie.setPath("/");    //任何请求都要携带凭证
                    cookie.setMaxAge(60*60*60);
                    response.addCookie(cookie);
                } else if(username.equals("")||password.equals("")){
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
    /**
     * 前台用户注册
     * author：zhangrui
     * time：2019/8/20-17：40
      */

    /**
     * 用户个人信息获取
     */
}
