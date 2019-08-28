package org.taru.producttracing.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.taru.producttracing.vo.JsonResult;


import java.io.File;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@RestController
@CrossOrigin()
public class PhotoApi {
    @Value("${web.upload.image-path}") //大括号里的都是key值   $表示调用配置文件     #表示调用xml配置文件
    private String imagepath;//动态路径


    @RequestMapping("/api/user/upload")
    public JsonResult upload(@RequestParam("image_header") MultipartFile multipartFile){
        JsonResult result=null;
        String []a=multipartFile.getOriginalFilename().split("\\.");//截取图片后缀名
        if(!multipartFile.isEmpty()){
            try {
                String filename= UUID.randomUUID().toString().replace("-", "")+"."+a[1];
                multipartFile.transferTo(new File(imagepath+"\\"+filename));
                result=new JsonResult("200","上传图片成功",filename);
            }catch (Exception e){
                e.printStackTrace();
                result=new JsonResult("500","上传图片失败","");
            }
        }else {
            result=new JsonResult("404","没有数据","");
        }
        return  result;

    }
}
