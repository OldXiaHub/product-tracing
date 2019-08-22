package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Admin;
import org.taru.producttracing.pojo.Factory;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    /**
     * 后台登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    public Admin adminLogin(@Param("adminName") String adminName,@Param("adminPassword")String adminPassword);

    /**
     * 添加工厂
     * @param factory
     * @return
     */
    public void addFactory(Factory factory );

    /**
     * 删除工厂
     * @param factoryId
     */
    public void updateFactory(@Param("factoryId") String factoryId);

    /**
     * 修改工厂信息
     * @param factory
     */
    public void modifyFactory(Factory factory);

    /**
     * 查询工厂
     * @return
     */
    public List<Factory> findAllFactory();


}
