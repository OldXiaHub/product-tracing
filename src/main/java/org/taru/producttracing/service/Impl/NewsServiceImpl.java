package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.NewsDao;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.NewsService;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    /**
     * 查询新闻
     * @return
     */
    @Override
    public  List<News> queryNews(){
        return newsDao.selectNews();
    }
    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    @Override
    public int deleteNews(String newsId){
        int news=newsDao.delNewsById(newsId);
        return news;
    }
    /**
     * 根据id查询新闻
     */
    public News selectNewsById(String newsId){
        return newsDao.selectNewsById(newsId);
    }
    /**
     *
     *
     * 根据时间排序新闻
     */
    public List<News> sortByTime(){
        return newsDao.sortByTime();
    }

}
