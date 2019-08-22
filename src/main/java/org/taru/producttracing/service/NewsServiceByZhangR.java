package org.taru.producttracing.service;

import org.taru.producttracing.pojo.News;

public interface NewsServiceByZhangR {

    /**
     * author:zhangrui
     * time：2019/08/20-19:50
     *发布新闻(插入一个新闻往数据库)
     */
    public int insertNews(News news);

    /**
     * author:zhangrui
     * time:2019/08/20-22:10
     * 修改新闻(根据新闻id)
     */
    public int reviseNews(News news);
}
