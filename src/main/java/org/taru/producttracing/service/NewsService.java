package org.taru.producttracing.service;
import org.taru.producttracing.pojo.News;

import java.util.List;
public interface NewsService {
    /**
     * 查询新闻
     * @return
     */
    List<News> queryNews();

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
     int deleteNews(String newsId);
    /**
     * 根据id查询新闻
     */
     News selectNewsById(String newsId);
    /**
     *
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
    List<News>  queryNewsLike(String newsName);
}
