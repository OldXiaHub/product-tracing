package org.taru.producttracing.service;

import org.springframework.stereotype.Service;
import org.taru.producttracing.pojo.Product;

import java.util.List;

@Service
public interface FoodManageService {
    public void insertProduct(Product product);
    public List<Product> selectProduct();
    public void deleteProduct(String productId);
    public List<Product> selectProductByid(String productId);
    public List<Product> fuzzySearch(String productName);
}
