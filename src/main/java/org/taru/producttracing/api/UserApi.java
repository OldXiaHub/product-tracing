package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Admin;
import org.taru.producttracing.pojo.Factory;
import org.taru.producttracing.service.UserService;
import org.taru.producttracing.util.SecurityUtl;
import org.taru.producttracing.vo.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class UserApi {
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 后台登录
     *
     * 湛玉欣 2019.8.21
     *
     * * @param adminName
     * @param adminPassword
     * @return
     */
    @RequestMapping("/api/adminlogin")
    public JsonResult adminLogin(String adminName, String adminPassword, HttpServletResponse response){
        JsonResult result=null;
        try{
            Admin admin=userService.login(adminName,adminPassword);
            System.out.println(admin);
            if(admin != null){
                String token_JsonId=SecurityUtl.getMd5String(adminName);
                redisTemplate.opsForHash().put("loginUserKey",token_JsonId, admin.getAdminId());
                Cookie cookie=new Cookie("token",token_JsonId);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*60);
                response.addCookie(cookie);
                result =new JsonResult("200","登陆成功",admin);
            }else{
                result =new JsonResult("404","登录失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","登录异常",e.getMessage());
        }
        return  result;
    }

    /**
     * 退出登录
     * 湛玉欣 2019.8.27
     * @param session
     * @return
     */
    @RequestMapping("/api/loginout")
    @ResponseBody
    public JsonResult loginOut(HttpSession session){
        JsonResult result=null;
        try{
            session.invalidate();
            redisTemplate.opsForHash().delete("loginUserKey");
            result =new JsonResult("200","退出登录成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","退出登录失败","");
        }
        return  result;
    }

    /**
     * 添加工厂
     *
     * 湛玉欣 2019.8.21
     *
     * @param factory
     * @return
     * @throws ParseException
     */
    @RequestMapping("/api/addfactory")
    public JsonResult addFactory(Factory factory) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        df.format(new Date());// new Date()为获取当前系统时间
          factory.setFactoryRegisterTime(df.format(new Date()));
          factory.setFactoryStatus(Long.valueOf(1));

        JsonResult result=null;
        try{
            userService.addFactory(factory);
            result =new JsonResult("200","添加工厂成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","添加工厂失败",e.getMessage());
        }
        return  result;
    }

    /**
     * 删除工厂
     *
     * 湛玉欣 2019.8.21
     *
     * @param factoryId
     * @return
     */
    @RequestMapping("/api/updatefactory")
    public JsonResult updateFactory(String factoryId){
        JsonResult result=null;
        try{
            userService.updateFactory(factoryId);
            result =new JsonResult("200","删除工场成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","删除工厂失败",e.getMessage());
        }
        return  result;
    }

    /**
     * 修改工厂信息
     *
     * 湛玉欣 2019.8.21
     *
     * @param factory
     * @return
     */
    @RequestMapping("/api/modifyfactory")
    public JsonResult modifuFactory(Factory factory){
        System.out.println(factory);
        JsonResult result=null;
        try{
            userService.modifyFactory(factory);
            System.out.println(factory);
            result =new JsonResult("200","修改工厂信息成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","修改工厂信息失败",e.getMessage());
        }
        return  result;
    }

    /**
     * 查询所有工厂
     *
     * 湛玉欣 2019.8.22
     *
     * @return
     */
    @RequestMapping("/api/findallfactory")
    public JsonResult findAllFactory(Integer pageNum,Integer pageSize){
        JsonResult result=null;
        try{

            PageHelper.startPage(pageNum,pageSize);//这条分页语句，一定要和下面将要进行分页的语句紧挨着
            List<Factory> factorys=userService.findAllFactory();
            PageInfo pageInfo=new PageInfo(factorys);

            if (factorys.size()>0){
                result =new JsonResult("200","查询所有工厂成功",pageInfo);
            }else{
                result =new JsonResult("404","查询工厂信息失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询工厂信息异常",e.getMessage());
        }
        return  result;
    }

    /**
     * 查询工厂详情
     *
     * 湛玉欣 2019.8.22
     *
     * @param factoryId
     * @return
     */
    @RequestMapping("/api/findfactorybyid")
    public JsonResult findFactoryById(String factoryId){
        JsonResult result=null;
        try{
            Factory factory=userService.findFactoryById(factoryId);
            if(factory != null){
                result =new JsonResult("200","查询工厂详情成功",factory);
            }else {
                result=new JsonResult("404","查询工厂详情失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询工厂详情异常",e.getMessage());
        }
        return  result;
    }

    /**
     * 模糊查询工厂
     * 湛玉欣 2019.8.23
     * @param factoryName
     * @return
     */
    @RequestMapping("/api/findfactorybyname")
    public JsonResult findFactoryByName(Integer pageNum,Integer pageSize,String factoryName){
        JsonResult result =null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Factory> factorys = userService.findAllFactoryByName(factoryName);
            PageInfo pageInfo=new PageInfo(factorys);
            if (factorys.size()>0){
                result =new JsonResult("200","查询工厂成功",pageInfo);
            }else{
                result =new JsonResult("404","查询工厂失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询工厂异常",e.getMessage());
        }
        return  result;
    }

    /**
     * 查询工厂名称
     * @return
     */
    @RequestMapping("/api/findallfactoryname")
    public JsonResult findAllFactoryName(){
        JsonResult result =null;
        try{
           List factoryNames=userService.findAllFactoryName();
           if(factoryNames.size()>0){
               result =new JsonResult("200","查询工厂名称成功",factoryNames);
           }else{
               result =new JsonResult("404","查询工厂名称失败","");
           }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询工厂名称异常","");
        }
        return  result;
    }
}
