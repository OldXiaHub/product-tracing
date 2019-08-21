package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Complain;

import java.util.List;

/**
 * 徐大伟 2019.8.20
 */
@Mapper
@Component
public interface LogisticsDao {
    /**
     * 查询所有投诉
     * @return
     */
    public List<Complain> queryAllComplain();

    /**
     * 受理投诉
     * @param complainId
     */
    public void acceptCom(@Param("complainId") String complainId);

}
