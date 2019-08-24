package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.FoodManageDao1;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.service.FoodManageService1;
import org.taru.producttracing.util.IdUtil;
import org.taru.producttracing.util.QRFactory;

/**
 * 徐大伟2019.8.22
 * 批次添加
 */
@Service
public class FoodManageServiceImpl1 implements FoodManageService1 {
    @Autowired
    FoodManageDao1 foodManageDao1;

    /**
     * 添加批次
     * @param batch
     */
    @Override
    public void addBatch(Batch batch) {
        String batchId = IdUtil.getDateId();
        batch.setBatchId(batchId);
        foodManageDao1.sendGoods(batch);
        QRFactory.creteQRFile(batch.getBatchBarcode());
        String qr=QRFactory.getImageBinary(batch.getBatchBarcode());
        System.out.println(qr);
        foodManageDao1.addQr(batch.getBatchId(),qr);
    }

    /**
     * 根据id 查询批次
     * @param batchId
     * @return
     */
    @Override
    public Batch queryBatch(String batchId) {
        return foodManageDao1.queryBatchById(batchId);
    }

}
