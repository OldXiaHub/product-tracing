package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.Impl.NewsServiceImpl;
import org.taru.producttracing.vo.JsonResult;

import java.util.List;

/**
 * Api  Application  program     interface   （接口服务  功能  方法）  Ajax  JSON
 */
@RestController  //可以省略掉 ResponseBody
@CrossOrigin(allowCredentials="true")
public class NewsApi {
    /**
     * 查询新闻
     */
    @Autowired
    NewsServiceImpl serviceImpl;

    @RequestMapping(value = "/api/adminews/selectApi")
    public JsonResult queryNews(){
        JsonResult  result=null;
       try {
           List<News> news=serviceImpl.queryNews();
           if(news==null){
               result=new JsonResult("404","没有新闻","");
           }else {
               result=new JsonResult("200","查询成功",news);
           }
       }catch (Exception e){
           e.printStackTrace();
           result  =new JsonResult("500","error","");
       }
    return result;
    }
    /**
     * 删除新闻
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/adminews/delnews")
    public JsonResult deleteNews(String id) {
        JsonResult  result=null;
        try {
            int i = serviceImpl.deleteNews(id);
            if (i!=0) {
                result = new JsonResult("200", "删除成功", i);
            } else {
                result = new JsonResult("400", "删除失败", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "error", "");
        }
        return result;
    }

}