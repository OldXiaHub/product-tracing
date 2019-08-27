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
     *
     * 湛玉欣 2019.8.21
     * @param factory
     * @return
     */
      void addFactory(Factory factory);

    /**
     * 删除工厂
     *
     * 湛玉欣 2019.8.21
     * @param factoryId
     */
    void updateFactory(String factoryId);

    /**
     * 修改工厂信息
     *
     * 湛玉欣 2019.8.21
     * @param factory
     */
    void modifyFactory(Factory factory);

    /**
     * 查询所有工厂
     *
     * 湛玉欣 2019.8.21
     * @return
     */
    List<Factory> findAllFactory();

    /**
     * 查询工厂详情
     *
     * 湛玉欣 2019.8.22
     *
     * @param factoryId
     * @return
     */
    Factory findFactoryById(String factoryId);

    /**
     * 模糊查询工厂
     * 湛玉欣 2019.8.23
     * @param factoryName
     * @return
     */
    List<Factory> findAllFactoryByName(String factoryName);

    /**
     * 查询工厂名称
     * 湛玉欣 2019.8.26
     * @return
     */
    List<Factory> findAllFactoryName();
}
