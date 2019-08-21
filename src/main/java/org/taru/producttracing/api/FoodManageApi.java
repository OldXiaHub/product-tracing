package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.taru.producttracing.pojo.Product;
import org.taru.producttracing.service.FoodManageService;
import org.taru.producttracing.util.IdUtil;
import org.taru.producttracing.vo.JsonResult;

import java.io.File;
import java.util.List;
/*
张露露 2019.8.21
 */
@RestController
public class FoodManageApi {
    @Autowired
    private FoodManageService foodManageService;

    //通过Value注解获得属性配置文件的信息 $
    @Value("${web.upload.image-path}")
    private String uploadAbsolutePath;
    /*
    食品添加
     */
    @RequestMapping("/api/adminfood/insertfood")
    public JsonResult insertProduct(String productName,
                                    @RequestParam("productPhoto") MultipartFile multipartFile,
                                    String productComment,
                                    String productCreateTime,
                                    String productQualityTime,
                                    String productComplainId,
                                    String productFactoryId,
                                    String productLogisticsId,
                                    String productBatchId,
                                    long productStatus){
        JsonResult jsonResult=null;
        if (!multipartFile.isEmpty()) {
            try {
                String productPhoto=IdUtil.getUuid()+multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File(uploadAbsolutePath+"\\"+productPhoto));
                String productId = IdUtil.getDateId();
                Product product = new Product();
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
                jsonResult = new JsonResult("200", "添加食品成功", productId);
            } catch (Exception e) {
                e.printStackTrace();
                jsonResult = new JsonResult("500", "添加食品失败", null);
            }
        }else {
            jsonResult=new JsonResult("404","没有数据","");
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
            System.out.println("???");
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
}
