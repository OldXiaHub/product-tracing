package org.taru.producttracing.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.dao.FoodDao1;
import org.taru.producttracing.service.FoodService1;

import java.util.List;

/**
 * 刘鹏飞 2019.8.20
 * * @param
 * @param
 * @return
 */
@Repository
public class FoodServiceImpl1 implements FoodService1 {
    @Autowired
    FoodDao1 foodDao;
    //查询所有新闻资讯信息
    public List queryNews() {
        return foodDao.queryNews();
    }

    //查询新闻详情(根据id)
    public List queryNewsById(String newsId) {
        return foodDao.queryNewsById(newsId);
    }

    //模糊搜索新闻资讯信息
    public List queryNewsByname(String newsName) {
        return foodDao.queryNewsByname(newsName);
    }


}
