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
    public int deleteNews(String newsId);
    /**
     * 根据id查询新闻
     */
    public News selectNewsById(String newsId);
    /**
     *
     *
     * 根据时间排序新闻
     */
    public List<News> sortByTime();

}
