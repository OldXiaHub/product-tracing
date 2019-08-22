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
     * @param id
     * @return
     */
    public int deleteNews(String id);
    /**
     * 根据id查询新闻
     */
    public News selectNewsById(String id);
}
