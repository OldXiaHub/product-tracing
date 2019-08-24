package org.taru.producttracing.service;

import org.taru.producttracing.pojo.Batch;

import java.util.List;

/**
 * 徐大伟2019.8.21
 * 批次发货
 */
public interface FoodManageService1 {
    /**
     * 添加批次
     * @param batch
     */
    public void addBatch(Batch batch);
    /**
     * id查询批次
     */
    public Batch queryBatch(String batchBarcode);
    /**
     * 查询所有批次
     */
    public List<Batch> queryall();
}
