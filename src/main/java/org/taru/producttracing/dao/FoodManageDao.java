package org.taru.producttracing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.producttracing.pojo.Product;

import java.util.List;

@Mapper
@Repository
public interface FoodManageDao {
    /**
     *添加食品
     */
  void insertProduct(Product product);
  /*
  查询食品
   */
  List<Product> selectProduct();

  /*
  食品作废
   */
   void deleteProduct(String productId);
   /*
   根据id查询食品
    */
   List<Product> selectProductByid(String productId);

}
