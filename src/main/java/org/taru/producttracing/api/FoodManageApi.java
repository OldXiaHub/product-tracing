package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Product;
import org.taru.producttracing.service.FoodManageService;
import org.taru.producttracing.vo.JsonResult;
import java.util.List;
/*
张露露 2019.8.21 19.42
 */
@CrossOrigin()
@RestController
public class FoodManageApi {
    @Autowired
    private FoodManageService foodManageService;

    /*
    食品添加
     */
    @RequestMapping("/api/adminfood/insertfood")
    public JsonResult insertProduct(Product product){
        JsonResult jsonResult=null;

            try {
                 foodManageService.insertProduct(product);
                jsonResult = new JsonResult("200", "添加食品成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                jsonResult = new JsonResult("500", "添加食品失败", null);
            }

        return jsonResult;

    }
/*
查询所有食品
 */
@RequestMapping("/api/adminfood/selectfood")
    public JsonResult selectProduct(Integer pageNum,Integer pageSize){
        JsonResult jsonResult=null;
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Product> list=foodManageService.selectProduct();
            PageInfo pageInfo=new PageInfo(list);
            if(list!=null){
                jsonResult=new JsonResult("200","查询成功",pageInfo);
            }else {
                jsonResult=new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500",e.getMessage(),"");
        }
        return jsonResult;
    }
    /*
    食品作废
     */
    @RequestMapping("/api/adminfood/deleteproduct")
    public JsonResult deleteProduct(String productId){
        JsonResult jsonResult=null;
        try {
            if (productId!=null){
                foodManageService.deleteProduct(productId);
                jsonResult=new JsonResult("200","删除成功",null);
            }else {
                jsonResult=new JsonResult("404","未输入id",null);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","出事了",e.getMessage());
        }
        return jsonResult;
    }

    /*
    根据id查食品
     */
    @RequestMapping("/api/adminfood/selectfoodbyid")
    public JsonResult selectProductByid(String productId){
        JsonResult jsonResult=null;
        try {
            List<Product> product=foodManageService.selectProductByid(productId);
            if(product!=null){
                jsonResult=new JsonResult("200","查询成功",product);
            }else {
                jsonResult=new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","出错了",e.getMessage());
        }
        return jsonResult;
    }

    /*模糊查询食品*/
    @RequestMapping("/api/adminfood/selectfoodbyname")
    public JsonResult selectProductByname(String productName){
        JsonResult jsonResult=null;
        try {
            List<Product> product=foodManageService.fuzzySearch(productName);
            if(product!=null){
                jsonResult=new JsonResult("200","查询成功",product);
            }else {
                jsonResult=new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","出错了",e.getMessage());
        }
        return jsonResult;
    }
}
