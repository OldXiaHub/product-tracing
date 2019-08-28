package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.NewsDao;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.NewsService;
import org.taru.producttracing.util.IdUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    /*发布新闻*/
    @Override
    public void insertNews(News news){
        String newId= IdUtil.getLongTimeId();
        news.setNewsId(newId);
        Date date = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=ss.format(date);
        news.setNewsTime(time);
        newsDao.insertNews(news);
    }

    /**
     * 新闻模糊查询
     * @param newsName
     * @return
     */
    public List<News> queryNewsLike(String newsName){
        return newsDao.queryNewsLike(newsName);
    }
}
