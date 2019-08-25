package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.LogisticsDao;
import org.taru.producttracing.pojo.Logistics;
import org.taru.producttracing.service.LogisticsService;

import java.util.List;

/**
 * 徐大伟2019.8.25
 * 查询物流信息
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    LogisticsDao logisticsDao;
    /**
     * 徐大伟2019.8.25
     * 查询物流信息
     */
    @Override
    public List<Logistics> query(String logisticsBatchBarcode) {
        return logisticsDao.queryRouter(logisticsBatchBarcode);
    }
}
