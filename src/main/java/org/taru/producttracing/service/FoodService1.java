package org.taru.producttracing.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.taru.producttracing.pojo.Complain;

import java.util.List;

/**
 * 刘鹏飞
 */
public interface FoodService1 {
    //查询新闻资讯信息
    List queryNews();
    //搜索新闻资讯信息
    List queryNewsByname(@Param("newsName") String newsName);
}
