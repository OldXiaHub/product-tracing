package org.taru.producttracing.service;

import org.springframework.stereotype.Service;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.Logistics;

import java.util.HashMap;
import java.util.List;

/**
 * 徐大伟2019.8.25
 * 查询物流信息
 */
@Service
public interface LogisticsService {
    /**
     * 查询所有物流
     */
    public List<Logistics> queryAllLog();

    /**
     * 徐大伟2019.8.25
     * 查询物流信息
     */
    public List<Logistics> query(String logisticsBatchBarcode);
    /**
     * 更新物流状态
     */
    public void updatestatus(String logisticsId);
    /**
     * 根据物流ID查询
     */
    public Logistics querymessage(String logisticsId);
    /**
     * 插入物流信息
     */
    public void insertmessage(Logistics logistics);
}
