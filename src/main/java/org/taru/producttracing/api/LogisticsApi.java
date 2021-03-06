package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.Logistics;
import org.taru.producttracing.service.LogisticsService;
import org.taru.producttracing.util.StringUtil;
import org.taru.producttracing.vo.JsonResult;

import java.util.HashMap;
import java.util.List;

/**
 * 徐大伟2019.8.20
 * 查询物流
 */

@RestController
public class LogisticsApi {
    @Autowired
    LogisticsService logisticsService;
    /**
     * 查询所有物流
     */
    @RequestMapping("/api/querylogis")
    public JsonResult queryAllRouter(Integer pageNum,Integer pageSize){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Logistics> logistics=logisticsService.queryAllLog();
            PageInfo pageInfo=new PageInfo(logistics);
            result=new JsonResult("200","查询成功",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","查询失败","");
        }
        return result;
    }
    /**
     * 徐大伟2019.8.20
     * 查询物流根据logisticsBatchBarcode
     */
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
    /**
     * 根据LogisticsId查询物流状态
     */
    @RequestMapping("/api/querylogistics")
    public JsonResult querylogistics(String logisticsId){
        JsonResult result=null;
        try{
            Logistics logistics=logisticsService.querymessage(logisticsId);
            result=new JsonResult("200","查询成功",logistics);
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","查询失败","");
        }
        return result;
    }
    /**
     *插入物流
     */
    @RequestMapping("/api/insertlogistics")
    public JsonResult insertligistic(Logistics logistics){
        JsonResult result=null;

        try{
            logisticsService.insertmessage(logistics);
            result=new JsonResult("200","插入成功","");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","插入失败","");
        }
        return result;
    }
    /**
     * 根据logisticsBatchBarcode模糊搜索
     */
    @RequestMapping("/api/fuzzysearch")
    public JsonResult fuzzysearchligistic(String logisticsBatchBarcode,Integer pageNum,Integer pageSize){
        JsonResult result=null;

        try{

            PageHelper.startPage(pageNum,pageSize);
            List<Logistics> logistics=logisticsService.fuzzy(logisticsBatchBarcode);
            PageInfo pageInfo=new PageInfo(logistics);
            result=new JsonResult("200","搜索成功",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","搜索失败","");
        }
        return result;
    }
}
