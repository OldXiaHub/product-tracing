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
    public List<News> selectNews();
    /**
     * 删除新闻
     */
    public int delNewsById(@Param("id") String id);
    /**
     * 根据id查询新闻
     *
     */
    public News selectNewsById(String id);
     /*发布新闻*/
    public void insertNews(News news);
}

