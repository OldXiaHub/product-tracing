package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.dao.FoodDao1;
import org.taru.producttracing.service.FoodService1;

import java.util.List;

/**
 * 刘鹏飞
 */
@Repository
public class FoodServiceImpl1 implements FoodService1 {
    @Autowired
    FoodDao1 foodDao;
    public List queryNews() {
        return foodDao.queryNews();
    }
}
