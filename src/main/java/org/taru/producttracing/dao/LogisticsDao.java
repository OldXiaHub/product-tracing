package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.Logistics;

import java.util.HashMap;
import java.util.List;
@Mapper
@Repository
public interface LogisticsDao {
    /**
     * 查询所有物流
     */
    public List<Logistics> queryAllRouter();
    /**
     * 插入物流信息
     */
    public void insert(Logistics logistics);
    /**
     * 徐大伟2019.8.25
     * 查询物流信息
     */
    public List<Logistics> queryRouter(@Param("logisticsBatchBarcode") String logisticsBatchBarcode);
    /**
     * 2019.8.26
     * 更新物流状态
     */
    public void update(@Param("logisticsId") String logisticsId);
    /**
     * 根据物流Id查询
     */
    public Logistics queryById(@Param("logisticsId") String logisticsId);
    /**
     *根据batchBarcode 模糊
     */
    public List<Logistics> fuzzySearch(@Param("logisticsBatchBarcode") String logisticsBatchBarcode);
}
