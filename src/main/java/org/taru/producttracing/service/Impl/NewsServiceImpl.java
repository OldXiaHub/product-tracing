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
    @Override
    public  List<News> queryNews(){
        return newsDao.selectNews();
    }
    @Override
    public int deleteNews(String id){
        int news=newsDao.delNewsById(id);
        return news;
    }

}
