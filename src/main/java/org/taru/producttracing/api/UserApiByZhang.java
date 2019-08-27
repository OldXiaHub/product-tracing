package org.taru.producttracing.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.User;
import org.taru.producttracing.service.FoodManageService1;
import org.taru.producttracing.service.UserServiceByZhangR;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.util.StringUtil;
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
    @Autowired
    FoodManageService1 foodManageService1;

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
    /**
     * 前台用户注册
     * author：zhangrui
     * time：2019/8/20-17：40
      */
    @RequestMapping(value = "/Api/user/register" , method = RequestMethod.POST)
    public JsonResult userRegister(@RequestParam(value = "openId", required = true) String openId,
                                   @RequestParam(value = "nickName", required = true) String nickName,
                                   @RequestParam(value = "userAddress", required = true) String userAddress,
                                   @RequestParam(value = "avatarUrl", required = true) String avatarUrl){
        JsonResult result=null;
        int i=0;
        if (openId!=null) {
            try {
                User user3 = userServiceByZhangR.getUserInfo(openId);
                if(user3==null){
                    i = userServiceByZhangR.register(openId, nickName, userAddress, avatarUrl);
                    User user1 = userServiceByZhangR.getUserInfo(openId);
                    result = new JsonResult("200", "注册成功", user1);
                }
                else {
                    result = new JsonResult("200","该用户已注册" , user3);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new JsonResult("500", e.getMessage(), i);
            }
        }else {
            result = new JsonResult("500", "openId为空", "");
        }
        return result;
    }


//    /**
//     * 添加用户个人信息
//     * author:zhangrui
//     * time:2019/8/21-15:37
//     */
//    @RequestMapping(value = "/api/user/adduserinfo" ,method = RequestMethod.POST)
//    public JsonResult addUserInfo(User user){
//        JsonResult result=null;
//        int i=0;
//        try{
//            i=userServiceByZhangR.addUserInfo(user);
//            if (i!=0){
//                result = new JsonResult("200", "添加用户个人信息成功", i);
//            }else {
//                result = new JsonResult("404", "添加用户个人信息失败", i);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            result = new JsonResult("500", e.getMessage(), "");
//        }
//        return result;
//    }

    /**
     * 查询自己的投诉记录
     * author:zhangrui
     * time:2019/8/22-9:30
     */
    @RequestMapping(value = "/Api/user/complain" ,  method = RequestMethod.GET)
    public JsonResult userComplain(String openId){
        JsonResult result=null;
        List<Complain> list=null;
        try{
            list=userServiceByZhangR.userComplain(openId);
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

    /**
     * 获取用户个人信息（根据ID）
     * author:zhangrui
     * time:2019/8/21-15:37
     */
    @RequestMapping(value = "/api/user/getuserinfo" ,method = RequestMethod.GET)
    public JsonResult getUserInfo(String openId){
        JsonResult result=null;
        User  user =null;
        try{
            user=userServiceByZhangR.getUserInfo(openId);
            if (user!=null){
                result = new JsonResult("200", "获取用户个人信息成功", user);
            }else {
                result = new JsonResult("404", "获取用户个人信息失败", "");
            }
        }catch(Exception e){
            e.printStackTrace();
            result = new JsonResult("500", e.getMessage(), "");
        }
        return result;
    }

    /**
     * 用户主动投诉
     * author:zhangrui
     * time:2019/8/22-23:10
     */
    @RequestMapping(value = "/Api/user/activecomplaint" ,method = RequestMethod.POST)
    public JsonResult complain(@RequestParam(value = "complainId", required = true) String complainId,
                               @RequestParam(value = "complainName", required = true) String complainName,
                               @RequestParam(value ="complainContent", required = true) String complainContent,
                               @RequestParam(value ="complainUserId", required = true) String complainUserId,
                               @RequestParam(value = "complainTime", required = true) String complainTime,
                               @RequestParam(value = "complainUserTelphone",required = true)String complainUserTelphone,
                               @RequestParam(value ="complainBatchBarcode",required = true)String complainBatchBarcode){
        JsonResult result=null;
        int i=0;
        try{
            i=userServiceByZhangR.complain(complainId,complainName,complainContent,complainUserId,complainTime,complainUserTelphone,complainBatchBarcode);
            if (i!=0){
                result = new JsonResult("200", "用户投诉成功", i);
            }else {
                result = new JsonResult("404", "用户投诉失败", "");
            }
        }catch(Exception e){
            e.printStackTrace();
            result = new JsonResult("500", e.getMessage(), "");
        }
        return result;
    }

    /**
     * 根据id查询批次
     * @return
     */
    @RequestMapping("/Api/querybatch")
    public JsonResult selectProduct(String batchBarcode){
        JsonResult jsonResult=null;
        try {
            Batch batch=foodManageService1.queryBatch(batchBarcode);
            if(batch!=null){
                jsonResult=new JsonResult("200","查询成功",batch);
            }else {
                jsonResult=new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500",e.getMessage(),"");
        }
        return jsonResult;
    }
}
