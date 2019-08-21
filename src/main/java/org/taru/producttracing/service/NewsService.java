package org.taru.producttracing.service;
import org.taru.producttracing.pojo.News;
import java.util.List;
public interface NewsService {
    List<News> queryNews();
    public int deleteNews(String id);
}
