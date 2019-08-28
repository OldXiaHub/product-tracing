package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.News;

import java.util.List;

@Mapper
@Repository
public interface NewsDao {
    /**
     * 查询新闻
     * @param
     * @return
     */
     List<News> selectNews();
    /**
     * 删除新闻
     */
     int delNewsById(@Param("newsId") String newsId);
    /**
     * 根据id查询新闻
     *
     */
     News selectNewsById(String newsId);
    /**
     *NewsDao
     *
     * 根据时间排序新闻
     */
     List<News> sortByTime();
    /*发布新闻*/
     void insertNews(News news);
    /**
     * 新闻模糊查询
     * @param newsName
     * @return
     */
    List<News>  queryNewsLike(@Param("newsName") String newsName);
}

