package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Param;
import org.taru.producttracing.pojo.Complain;

public interface FoodDao2 {
    /**
     * 徐大伟2019.8.20
     * 用户投诉(登录之后)
     */
    public void addComplain(@Param("complain") Complain complain);
}
