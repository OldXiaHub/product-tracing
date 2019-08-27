package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.LogisticsDao;
import org.taru.producttracing.pojo.Logistics;
import org.taru.producttracing.service.LogisticsService;
import org.taru.producttracing.util.IdUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
     * 查询所有物流
     */

    @Override
    public List<Logistics> queryAllLog() {
        return logisticsDao.queryAllRouter();
    }

    /**
     * 徐大伟2019.8.25
     * 查询物流信息
     */
    @Override
    public List<Logistics> query(String logisticsBatchBarcode) {
        return logisticsDao.queryRouter(logisticsBatchBarcode);
    }
    /**
     * 更新物流状态
     */
    @Override
    public void updatestatus(String logisticsId) {
        logisticsDao.update(logisticsId);
    }

    /**
     * 根据物流Id
     * @param logisticsId
     * @return
     */
    @Override
    public Logistics querymessage(String logisticsId) {
        return logisticsDao.queryById(logisticsId);
    }

    /**
     * 插入物流信息
     * @param logistics
     */
    @Override
    public void insertmessage(Logistics logistics) {
        String logisticsId = IdUtil.getDateId();
        logistics.setLogisticsId(logisticsId);
        logisticsDao.insert(logistics);
    }

    @Override
    public List<Logistics> fuzzy(String logisticsBatchBarcode) {
        return logisticsDao.fuzzySearch(logisticsBatchBarcode);
    }
}
