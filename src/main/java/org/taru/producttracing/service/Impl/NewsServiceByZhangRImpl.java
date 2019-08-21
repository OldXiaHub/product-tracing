package org.taru.producttracing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.NewsDaoByZhangR;
import org.taru.producttracing.pojo.News;
import org.taru.producttracing.service.NewsServiceByZhangR;
import org.taru.producttracing.util.StringUtil;

import java.util.UUID;

@Service
public class NewsServiceByZhangRImpl implements NewsServiceByZhangR {
    @Autowired
    NewsDaoByZhangR newsDaoByZhangR;
    /**
     * author:zhangrui
     * time：2019/08/20-20:10
     *发布新闻(插入一个新闻往数据库)
     */
    @Override
    public int insertNews(News news) {
        int i;
        int k=2;
        UUID newid=UUID.randomUUID();
        news.setNewsId(StringUtil.valueof(newid));
        i= newsDaoByZhangR.insertNews(news);
        if(news.getNewsName()!=""&&news.getNewsPhoto()!=""&&news.getNewsContent()!=""&&news.getNewsTime()!=""){
            return i;
        }
        return k;
    }

    /**
     * author:zhangrui
     * time:2019/08/20-22:20
     * 修改新闻(根据新闻id)
     */
    @Override
    public int reviseNews(String newsId) {
        int i=0;
        i= newsDaoByZhangR.reviseNews(newsId);
        return i;
    }


}
