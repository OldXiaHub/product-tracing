package org.taru.producttracing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.service.LogisticsServicedao;
import org.taru.producttracing.vo.JsonResult;

import java.util.List;
/**
 * 徐大伟
 * 投诉模块
 */
@CrossOrigin()
@RestController
public class LogisticsApi {
    @Autowired
    LogisticsServicedao logisticsServicedao;
    /**
     * 查看所有投诉
     */
    @RequestMapping(value = "/api/adminlog/querycomplain")
    public JsonResult queryAll(Integer pageNum,Integer pageSize){
        JsonResult result=null;
        PageHelper.startPage(pageNum,pageSize);
        List<Complain> list= logisticsServicedao.queryComplain();
        PageInfo pageinfo=new PageInfo(list);
        try{
            PageHelper.startPage(pageNum,pageSize);
            PageInfo pageInfo=new PageInfo(list);
            if(list.size()>0){
                result=new JsonResult("200","查询成功",pageInfo);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result=new JsonResult("500","error","");
        }
        return result;
    }
    /**
     * 受理投诉
     */
    @RequestMapping(value = "/api/adminlog/accept")
    public JsonResult acceptCom(String complainId){
        JsonResult result=null;
         logisticsServicedao.acceptComplain(complainId);
        try{
                result=new JsonResult("200","受理成功","");
        }catch (Exception ex){
            ex.printStackTrace();
            result=new JsonResult("500","error","");
        }
        return result;
    }
}
