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
    @RequestMapping("/api/insertbatch")
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
    @RequestMapping("/api/querybatch")
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
    @RequestMapping("/api/queryallbatch")
    public JsonResult queryBatch(Integer pageNum,Integer pageSize){
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
    /**
     * 查询批次产品
     * @return
     */
    @RequestMapping("/api/querybatchproduct")
    public JsonResult queryBatchProduct(){
        JsonResult jsonResult=null;
        try {
            List<Batch> batch=foodManageService1.querybatchproduct();
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
     * 删除批次
     */
    @RequestMapping("/api/updatebatch")
    public JsonResult update(String batchId){
        JsonResult jsonResult=null;
        try {
            foodManageService1.deletebatch(batchId);
                jsonResult=new JsonResult("200","删除成功","");
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500",e.getMessage(),"");
        }
        return jsonResult;
    }
}
