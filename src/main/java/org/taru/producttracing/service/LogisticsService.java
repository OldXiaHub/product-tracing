package org.taru.producttracing.service;

import org.springframework.stereotype.Service;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.pojo.Logistics;

import java.util.List;

/**
 * 徐大伟2019.8.25
 * 查询物流信息
 */
@Service
public interface LogisticsService {
    /**
     * 徐大伟2019.8.25
     * 查询物流信息
     */
    public List<Logistics> query(String logisticsBatchBarcode);
}
