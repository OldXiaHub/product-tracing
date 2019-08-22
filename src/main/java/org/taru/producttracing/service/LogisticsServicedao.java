package org.taru.producttracing.service;

import org.taru.producttracing.pojo.Complain;

import java.util.List;

/**
 * 徐大伟2019.8.20
 * 投诉模块
 */

public interface LogisticsServicedao {

    /**
     * 查看所有投诉
     */
    public List<Complain> queryComplain();
    /**
     * 受理投诉
     */
    public void acceptComplain(String complainId);
}
