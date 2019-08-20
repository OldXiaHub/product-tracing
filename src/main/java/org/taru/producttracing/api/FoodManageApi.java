package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Product;
import org.taru.producttracing.service.FoodManageService;
import org.taru.producttracing.util.IdUtil;
import org.taru.producttracing.vo.JsonResult;

import java.util.List;

@RestController
public class FoodManageApi {
    @Autowired
    private FoodManageService foodManageService;
    @RequestMapping("/Api/insertfood")
    /*
    食品添加
     */
    public JsonResult insertProduct(String productName,
                                    String productPhoto,
                                    String productComment,
                                    String productCreateTime,
                                    String productQualityTime,
                                    String productComplainId,
                                    String productFactoryId,
                                    String productLogisticsId,
                                    String productBatchId,
                                    long productStatus){
        JsonResult jsonResult=null;
        try {
            String productId = IdUtil.getDateId();
            Product product=new Product();
                product.setProductId(productId);
                product.setProductName(productName);
                product.setProductPhoto(productPhoto);
                product.setProductComment(productComment);
                product.setProductCreateTime(productCreateTime);
                product.setProductQualityTime(productQualityTime);
                product.setProductComplainId(productComplainId);
                product.setProductFactoryId(productFactoryId);
                product.setProductLogisticsId(productLogisticsId);
                product.setProductBatchId(productBatchId);
                product.setProductStatus(productStatus);
            foodManageService.insertProduct(product);
            jsonResult=new JsonResult("200","添加食品成功",productId);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("404","添加食品失败",null);
        }
        return jsonResult;

    }
/*
查询所有食品
 */
@RequestMapping("/Api/selectproduct")
    public JsonResult selectProduct(){
        JsonResult jsonResult=null;
        try {
            List<Product> list=foodManageService.selectProduct();
            if(list!=null){
                jsonResult=new JsonResult("200","查询成功",list);
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
    @RequestMapping("/Api/deleteproduct")
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
}
