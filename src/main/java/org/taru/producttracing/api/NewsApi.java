package org.taru.producttracing.api;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.Impl.NewsServiceImpl;
import org.taru.producttracing.vo.JsonResult;
import java.util.List;

/**
 * Api  Application  program     interface   （接口服务  功能  方法）  Ajax  JSON
 */
@RestController  //可以省略掉 ResponseBody
@CrossOrigin
public class NewsApi {
    /**
     * 查询新闻 王凯飞
     */
    @Autowired
    NewsServiceImpl serviceImpl;
    @RequestMapping(value = "/api/adminnews/selectApi")
    public JsonResult queryNews(Integer pageNum,Integer pageSize){
        JsonResult  result=null;
       try {
           PageHelper.startPage(pageNum,pageSize);
           List<News> news=serviceImpl.queryNews();
           PageInfo pageInfo=new PageInfo(news);
           if(news==null){
               result=new JsonResult("404","没有新闻","");
           }else {
               result=new JsonResult("200","查询成功",pageInfo);
           }
       }catch (Exception e){
           e.printStackTrace();
           result  =new JsonResult("500","error","");
       }
    return result;
    }
    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    @RequestMapping(value = "/api/adminnews/delnews")
    public JsonResult deleteNews(String newsId) {
        JsonResult  result=null;
        try {
            int i=serviceImpl.deleteNews(newsId);
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
    /**
     * 根据id查询新闻
     */
    @RequestMapping(value = "/api/adminnews/selectNewsById")
    public JsonResult selectNewsById(String newsId) {
        JsonResult  result=null;
        try {
            News news=serviceImpl.selectNewsById(newsId);
            if (news!=null) {
                result = new JsonResult("200", "查询成功", news);
            } else {
                result = new JsonResult("400", "查询失败", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "error", "");
        }
        return result;
    }
    /**
     * 根据时间排序
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/api/adminnews/sortByTime")
    public JsonResult sortByTime(Integer pageNum,Integer pageSize){
        JsonResult  result=null;
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<News> news=serviceImpl.sortByTime();
            PageInfo pageInfo=new PageInfo(news);
            if(news==null){
                result=new JsonResult("404","排序失败","");
            }else {
                result=new JsonResult("200","排序成功",pageInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
            result  =new JsonResult("500","error","");
        }
        return result;
    }

    /*发布新闻*/
    @RequestMapping(value = "/api/adminnews/insertNews")
    public JsonResult insertNews(News news){
        JsonResult result=null;
        if (news!=null) {
            try {
                serviceImpl.insertNews(news);
                result = new JsonResult("200", "发布新闻成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                result = new JsonResult("500", "发布新闻失败", null);
            }
        }else {
            result = new JsonResult("404", "未输入", null);
        }

        return result;
    }

    /**
     * 新闻模糊查询(带分页)
     * @param newsName
     * @return
     */
    @RequestMapping("api/adminnews/querynewslike")
    public JsonResult queryNewsLike(String newsName,Integer pageNum,Integer pageSize){
        JsonResult jsonResult=null;
        if(newsName!=null){
            try{
                PageHelper.startPage(pageNum,pageSize);
                List<News>  list= serviceImpl.queryNewsLike(newsName);
                PageInfo pageinfo=new PageInfo(list);
                jsonResult=new JsonResult("200","查询成功",pageinfo);
            }catch(Exception e){
                e.printStackTrace();
                jsonResult=new JsonResult("500",e.getMessage(),"");
            }
        }else{
            jsonResult=new JsonResult("404","查询失败","");
        }
        return jsonResult;
    }
}
