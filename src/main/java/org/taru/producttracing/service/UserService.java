package org.taru.producttracing.service;

import org.springframework.stereotype.Service;
import org.taru.producttracing.pojo.Admin;
import org.taru.producttracing.pojo.Factory;

import java.util.List;


public interface UserService {
     /**
      * 后台登录
      * @param adminName
      * @param adminPassword
      * @return
      */
     Admin login(String adminName,String adminPassword);

    /**
     * 添加工场
     * @param factory
     * @return
     */
      void addFactory(Factory factory);

    /**
     * 删除工厂
     * @param factoryId
     */
    void updateFactory(String factoryId);

    /**
     * 修改工厂信息
     * @param factory
     */
    void modifyFactory(Factory factory);

    /**
     * 查询所有工厂
     * @return
     */
    List<Factory> findAllFactory();
}
