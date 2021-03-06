package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.ComplainDao;
import org.taru.producttracing.pojo.Complain;
import org.taru.producttracing.service.ComplainService;

import java.util.List;
/**
 * 徐大伟2019.8.20
 * 投诉模块
 */

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    ComplainDao complainDao;
    /**
     * 查看所有投诉
     */
    @Override
    public List<Complain> queryComplain() {
        return  complainDao.queryAllComplain();
    }
    /**
     * 受理投诉
     */
    @Override
    public void acceptComplain(String complainId,long complainStatus) {
        complainDao.acceptCom(complainId,complainStatus);
    }

    /**
     * 查看投诉详情
     * @param complainId
     * @return
     */
    @Override
    public Complain queryComplain(String complainId) {
        return complainDao.queryComplainById(complainId);
    }

    /**
     * 模糊查询
     * @param complainContent
     * @return
     */
    @Override
    public List<Complain> fuzzycomplain(String complainContent) {
        return complainDao.fuzzy(complainContent);
    }

}
