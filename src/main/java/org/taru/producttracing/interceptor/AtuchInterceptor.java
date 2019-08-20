package org.taru.producttracing.interceptor;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.taru.producttracing.vo.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtuchInterceptor implements HandlerInterceptor {
    public AtuchInterceptor(){
        System.out.println("AtuchInterceptor is AtuchInterceptor");
    }
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object object) throws Exception {
        Cookie[]cookies=Request.getCookies();
        if(cookies!=null && cookies.length>0){
            for(Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    String token_jsessionId=cookie.getValue();
                    redisTemplate.opsForHash().get("loginUserKey",token_jsessionId);
                    if(object!=null){
                        return true;
                    }
                }
            }
        }
        JsonResult jsonResult=new JsonResult("500","没有令牌，无法登陆","");
        /*Response.setContentType("application/json:charset=UTF_8");*/
        Response.getWriter().write(new Gson().toJson(jsonResult));
        Response.getWriter().flush();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
