package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
/**
 * 刘鹏飞
 */
public interface FoodDao1 {
    //查询新闻资讯信息
    List queryNews();

}
