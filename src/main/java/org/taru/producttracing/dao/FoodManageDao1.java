package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Batch;

/**
 * 徐大伟2019.8.21
 * 批次发货
 */
@Mapper
@Repository
public interface FoodManageDao1 {
    /**
     * 添加批次
     * @param batch
     */
    public void sendGoods( Batch batch);
    /**
     * 根据ID查询批次
     */
    public Batch queryBatchById(@Param("batchBarcode") String batchBarcode);
    /**
     * 插入批次表二维码
     */
    public void addQr(@Param("batchId") String batchId,@Param("qr") String qr);
}
