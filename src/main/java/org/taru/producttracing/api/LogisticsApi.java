package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.Logistics;
import org.taru.producttracing.service.LogisticsService;
import org.taru.producttracing.vo.JsonResult;

import java.util.List;

/**
 * 徐大伟2019.8.20
 * 查询物流
 */

@RestController
public class LogisticsApi {
    @Autowired
    LogisticsService logisticsService;

    @RequestMapping("/api/queryrouter")
    public JsonResult queryRouter(String logisticsBatchBarcode){
        JsonResult result=null;
        try{
            List<Logistics> logistics=logisticsService.query(logisticsBatchBarcode);
            result=new JsonResult("200","查询成功",logistics);
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","查询失败","");
        }
        return result;
    }
    /**
     * 更新物流状态
     */
    @RequestMapping("/api/updatestatus")
    public JsonResult updateStatu(String logisticsId){
        JsonResult result=null;
        try{
           logisticsService.updatestatus(logisticsId);
            result=new JsonResult("200","修改成功","");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","修改失败","");
        }
        return result;
    }
}
