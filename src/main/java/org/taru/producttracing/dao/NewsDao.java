package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.taru.producttracing.pojo.News;

@Mapper
@Component
public interface NewsDao {

    /**
     * author:zhangrui
     * time：2019/08/20-19:40
     *发布新闻(插入一个新闻往数据库)
     */
    public int insertNews(News news);

    /**
     * author:zhangrui
     * time:2019/08/20-22:00
     * 修改新闻(根据新闻id)
     */
    public int reviseNews(String newsId);
}
