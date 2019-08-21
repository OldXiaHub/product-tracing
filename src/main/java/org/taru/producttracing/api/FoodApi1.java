package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.service.FoodService1;
import org.taru.producttracing.vo.JsonResult;

import java.util.List;
@CrossOrigin
@RestController
/**
 * 刘鹏飞
 */
public class FoodApi1 {
        @Autowired
        FoodService1 foodService;
    //查询权限(分级)
        @RequestMapping("/api/food/queryNews")
    public JsonResult queryPriv(){
        JsonResult result=null;
        try{
            List list= foodService.queryNews();
            result=new JsonResult("200","查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","查询失败","");
        }
        return result;
    }

}
