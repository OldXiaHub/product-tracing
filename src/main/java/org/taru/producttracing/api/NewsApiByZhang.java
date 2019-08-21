package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.NewsServiceByZhangR;
import org.taru.producttracing.vo.JsonResult;

@CrossOrigin
@RestController
public class NewsApiByZhang {
    @Autowired
    NewsServiceByZhangR newsServiceByZhangR;

    /**
     * author:zhangrui
     * time：2019/08/20-20:30
     *发布新闻(插入一个新闻往数据库)
     */
    @RequestMapping(value = "/api/adminews/releaseNews",method = RequestMethod.POST)
    public JsonResult releaseNews(News news){
        JsonResult result;
        int i=0;
            try{
                i= newsServiceByZhangR.insertNews(news);
                if(i==1){
                    result = new JsonResult("200", "插入新闻成功",i);
                }else {
                    result = new JsonResult("404", "插入新闻失败",i);
                }
            }catch (Exception e){
                e.printStackTrace();
                result = new JsonResult("500", "插入新闻异常",i);
            }

        return result;
    }

    /**
     * author:zhangrui
     * time:2019/08/20-22:22
     * 修改新闻(根据新闻id)
     */
    @RequestMapping(value = "/api/adminews/modifynews/", method = RequestMethod.POST)
    public JsonResult alter(String newsId){
        JsonResult result;
        int i=0;
        try{
            i = newsServiceByZhangR.reviseNews(newsId);
            if(i==1){
                result=new JsonResult("200","修改新闻成功",i);
            }else {
                result=new JsonResult("404","修改新闻失败",i);
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("500",e.getMessage(),i);
        }
        return result;
    }
}
