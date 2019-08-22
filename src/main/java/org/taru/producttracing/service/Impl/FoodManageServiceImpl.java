package org.taru.producttracing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.producttracing.dao.FoodManageDao;
import org.taru.producttracing.pojo.Product;
import org.taru.producttracing.service.FoodManageService;

import java.util.List;
/*
张露露 2019.8.20
 */

@Service
public class FoodManageServiceImpl implements FoodManageService {
    @Autowired
    private FoodManageDao foodManageDao;
    /*
    食品添加
     */
    @Override
    public void insertProduct(Product product){
        foodManageDao.insertProduct(product);
    }
    /*
    查询所有食品
     */
    @Override
    public List<Product> selectProduct(){
        return foodManageDao.selectProduct();
    }
    /*
    食品作废
     */
    @Override
    public void deleteProduct(String productId){
        foodManageDao.deleteProduct(productId);
    }
}
