package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.pojo.Product;
import org.taru.producttracing.service.FoodManageService1;
import org.taru.producttracing.util.IdUtil;
import org.taru.producttracing.vo.JsonResult;

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
    public JsonResult insertProduct(String batchName,
                                    String batchTime,
                                    Integer batchStatus,
                                    String batchProductId,
                                    String batchProductName,
                                    String batchProductPhoto,
                                    String batchProductComment,
                                    String batchProductCreateTime,
                                    String batchProductQualityTime,
                                    String batchFactoryId,
                                    double batchStartGeo,
                                    double batchEndGeo
                                    ){
        JsonResult jsonResult=null;
        try {
            String batchId = IdUtil.getDateId();
            Batch batch=new Batch();
            batch.setBatchId(batchId);
            batch.setBatchName(batchName);
            batch.setBatchTime(batchTime);
            batch.setBatchStatus(batchStatus);
            batch.setBatchProductId(batchProductId);
            batch.setBatchProductName(batchProductName);
            batch.setBatchProductPhoto(batchProductPhoto);
            batch.setBatchProductComment(batchProductComment);
            batch.setBatchProductCreateTime(batchProductCreateTime);
            batch.setBatchProductQualityTime(batchProductQualityTime);
            batch.setBatchFactoryId(batchFactoryId);
            batch.setBatchStartGeo(batchStartGeo);
            batch.setBatchEndGeo(batchEndGeo);
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
    public JsonResult selectProduct(String batchId){
        JsonResult jsonResult=null;
        try {
            Batch batch=foodManageService1.queryBatch(batchId);
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
