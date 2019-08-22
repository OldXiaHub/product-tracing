package org.taru.producttracing.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.taru.producttracing.pojo.Complain;

import java.util.List;

/**
 * 刘鹏飞 2019.8.20
 * * @param
 * @param
 * @return
 */
public interface FoodService1 {
    //查询所有新闻资讯信息
    List queryNews();

    //查询新闻详情(根据id)

    List queryNewsById(String newsId);
    //模糊搜索新闻资讯信息

    List queryNewsByname(@Param("newsName") String newsName);
}
