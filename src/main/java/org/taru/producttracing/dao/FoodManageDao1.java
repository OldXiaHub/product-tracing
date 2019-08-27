package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Batch;

import java.util.List;

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
    public void addQr(@Param("batchBarcode") String batchBarcode,@Param("qr") String qr);
    /**
     * 查询所有批次
     */
    public List<Batch> querybatch();
    /**
     * 查询批次产品
     */
    public List<Batch> query();
    /**
     * 删除批次
     */
    public void update(@Param("batchId") String batchId);
}
