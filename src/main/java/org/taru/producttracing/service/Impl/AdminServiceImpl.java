package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.UserDao;
import org.taru.producttracing.pojo.Admin;
import org.taru.producttracing.pojo.Factory;
import org.taru.producttracing.service.UserService;

import java.util.List;

@Service
public class AdminServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 后台登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    public Admin login(String adminName, String adminPassword) {
        Admin admin=userDao.adminLogin(adminName,adminPassword);
        return admin;
    }

    /**
     * 添加工场
     * @param factory
     * @return
     */
    @Override
    public void addFactory(Factory factory) {
        userDao.addFactory(factory);
    }

    /**
     * 删除工厂
     * @param factoryId
     */
    @Override
    public void updateFactory(String factoryId) {
        userDao.updateFactory(factoryId);
    }

    /**
     * 修改工厂信息
     * @param factory
     */
    @Override
    public void modifyFactory(Factory factory) {
        userDao.modifyFactory(factory);
    }

    /**
     * 查询所有工厂
     * @return
     */
    @Override
    public List<Factory> findAllFactory() {
        List<Factory> factories=userDao.findAllFactory();
        return factories;
    }

    /**
     * 查询工厂详情
     *
     * 湛玉欣 2019.8.22
     *
     * @param factoryId
     * @return
     */
    @Override
    public Factory findFactoryById(String factoryId) {
        Factory factory=userDao.findFactoryById(factoryId);
        return factory;
    }

}
