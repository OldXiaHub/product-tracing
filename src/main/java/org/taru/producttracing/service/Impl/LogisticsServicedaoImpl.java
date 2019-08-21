package org.taru.producttracing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.LogisticsDao;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.service.LogisticsServicedao;

import java.util.List;
@Service
public class LogisticsServicedaoImpl implements LogisticsServicedao {
    @Autowired
    LogisticsDao logisticsDao;
    @Override
    public List<Complain> queryComplain() {
        return  logisticsDao.queryAllComplain();
    }

    @Override
    public void acceptComplain(String complainId) {
       logisticsDao.acceptCom(complainId);
    }
}
