package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Complain;

import java.util.List;
@Mapper
@Repository
/**
 * 刘鹏飞 2019.8.20
 * * @param
 * @param
 * @return
 */
public interface FoodDao1 {
    //查询新闻资讯信息
    List queryNews();
    //查询新闻详情(根据id)
    List queryNewsById(String newsId);
    //模糊搜索新闻资讯信息
    List queryNewsByname(@Param("newsName") String newsName);
}
