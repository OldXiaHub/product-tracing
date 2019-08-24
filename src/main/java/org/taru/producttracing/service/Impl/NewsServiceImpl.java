package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.NewsDao;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.NewsService;
import org.taru.producttracing.util.IdUtil;

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
     * @param id
     * @return
     */
    @Override
    public int deleteNews(String id){
        int news=newsDao.delNewsById(id);
        return news;
    }
    /**
     * 根据id查询新闻
     */
    public News selectNewsById(String id){
        return newsDao.selectNewsById(id);
    }
    /*发布新闻*/
    @Override
    public void insertNews(News news){
        String newId= IdUtil.getLongTimeId();
        news.setNewsId(newId);
        newsDao.insertNews(news);
    }
}
