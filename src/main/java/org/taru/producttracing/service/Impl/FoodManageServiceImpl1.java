package org.taru.producttracing.service.Impl;

import org.apache.ibatis.annotations.Lang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.FoodManageDao1;
import org.taru.producttracing.pojo.Batch;
import org.taru.producttracing.service.FoodManageService1;
import org.taru.producttracing.util.IdUtil;
import org.taru.producttracing.util.QRFactory;
import org.taru.producttracing.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 徐大伟2019.8.22
 * 批次添加
 */
@Service
public class FoodManageServiceImpl1 implements FoodManageService1 {
    String qr;
    String brcode;
    @Value("${web.upload.imagepath}") //大括号里的都是key值   $表示调用配置文件     #表示调用xml配置文件
    private String imagepath;//动态路径
    @Autowired
    FoodManageDao1 foodManageDao1;
    /**
     * 添加批次
     * @param batch
     */
    @Override
    public void addBatch(Batch batch) {
        Date date = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s=batch.getBatchTime();
        s=ss.format(date);
        batch.setBatchTime(s);
        String batchId = IdUtil.getDateId();
        batch.setBatchId(batchId);
        batch.setBatchProductId(IdUtil.getUuid());
        brcode=batch.getBatchQrcode();
        foodManageDao1.sendGoods(batch);
        QRFactory.creteQRFile(batch.getBatchBarcode());
        qr=QRFactory.getImageBinary(batch.getBatchBarcode());
//        System.out.println(qr);
        foodManageDao1.addQr(batch.getBatchBarcode(),qr);
    }

    /**
     * 根据id 查询批次
     * @param batchBarcode
     * @return
     */
    @Override
    public Batch queryBatch(String batchBarcode) {
        return foodManageDao1.queryBatchById(batchBarcode);
    }

    /**
     * 查询所有批次
     * @return
     */
    @Override
    public List<Batch> queryall() {
        List<Batch> list = foodManageDao1.querybatch();
        for(Batch item : list)
        {
//            qr = item.getBatchQrcode();
//            QRFactory.base64StringToImage(imagepath+item.getBatchBarcode()+".jpg",qr);
            item.setBatchQrcode(null);
        }
        return list;
    }
    /**
     * 查询批次产品
     */
    public List<Batch> querybatchproduct(){

        return foodManageDao1.query();
    }

    /**
     * 删除批次
     * @param batchId
     */
    @Override
    public void deletebatch(String batchId) {
        foodManageDao1.update(batchId);
    }
}
