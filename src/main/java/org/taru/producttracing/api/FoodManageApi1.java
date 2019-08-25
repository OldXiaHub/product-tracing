package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Batch;

import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.service.FoodManageService1;

import org.taru.producttracing.vo.JsonResult;

import java.util.List;

/**
 * 徐大伟2019.8.21
 * 添加批次
 */
@RestController
public class FoodManageApi1 {
    @Autowired
    FoodManageService1 foodManageService1;
    @RequestMapping("/Api/insertbatch")
    /*
    批次添加
     */
    public JsonResult insertProduct(Batch batch){
        JsonResult jsonResult=null;
        try {
            foodManageService1.addBatch(batch);
            jsonResult=new JsonResult("200","添加批次成功",batch);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("404","添加批次失败",null);
        }
        return jsonResult;
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
    /**
     * 查询所有批次
     * @return
     */
    @RequestMapping("/Api/queryallbatch")
    public JsonResult querybatch(Integer pageNum,Integer pageSize){
        JsonResult jsonResult=null;
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Batch> batch=foodManageService1.queryall();
            PageInfo pageInfo=new PageInfo(batch);

            if(batch!=null){
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
}
