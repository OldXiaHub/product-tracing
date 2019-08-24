
package org.taru.producttracing.api;
        import com.github.pagehelper.PageHelper;
        import com.github.pagehelper.PageInfo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import org.taru.producttracing.pojo.Complain;
        import org.taru.producttracing.service.ComplainService;
        import org.taru.producttracing.vo.JsonResult;
        import java.util.List;
/**
 * 徐大伟
 * 投诉模块
 */
@CrossOrigin()
@RestController
public class ComplainApi {

    @Autowired
    ComplainService complainService;
    /**
     * 查看所有投诉
     */
    @RequestMapping(value = "/api/adminlog/querycomplain")
    public JsonResult queryAll(Integer pageNum,Integer pageSize){
        JsonResult result=null;
        PageHelper.startPage(pageNum,pageSize);
        List<Complain> list= complainService.queryComplain();
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
    public JsonResult acceptCom(String complainId,long complainStatus){
        JsonResult result=null;
        complainService.acceptComplain(complainId,complainStatus);
        try{
            result=new JsonResult("200","受理成功","");
        }catch (Exception ex){
            ex.printStackTrace();
            result=new JsonResult("500","error","");
        }
        return result;
    }
    /**
     * 查看投诉详情
     */
    @RequestMapping(value = "/api/adminlog/querycomplainById")
    public JsonResult query(String complainId){
        JsonResult result=null;
        Complain complain= complainService.queryComplain(complainId);
        try{
            if( complain != null){
                result=new JsonResult("200","查询成功",complain);
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
     * 模糊查询投诉
     */
    @RequestMapping(value = "/api/adminlog/fuzzycomplain")
    public JsonResult fuuzy(String complainName){
        JsonResult result=null;
        List<Complain> complain= complainService.fuzzycomplain(complainName);
        System.out.println(complain);
        try{
            if( complain.size()>0){
                result=new JsonResult("200","查询成功",complain);
            }else {
                result=new JsonResult("400","查询失败","");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result=new JsonResult("500","error","");
        }
        return result;
    }
}
