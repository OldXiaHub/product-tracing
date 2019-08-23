package org.taru.producttracing.pojo;


import java.util.List;

public class Product {

  private String productId;
  private String productName;
  private String productPhoto;
  private String productComment;
  private String productFactoryId;
  private long productStatus;
  private List<Factory> factory;

  public List<Factory> getFactory() {
    return factory;
  }

  public void setFactory(List<Factory> factory) {
    this.factory = factory;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductPhoto() {
    return productPhoto;
  }

  public void setProductPhoto(String productPhoto) {
    this.productPhoto = productPhoto;
  }


  public String getProductComment() {
    return productComment;
  }

  public void setProductComment(String productComment) {
    this.productComment = productComment;
  }


  public String getProductFactoryId() {
    return productFactoryId;
  }

  public void setProductFactoryId(String productFactoryId) {
    this.productFactoryId = productFactoryId;
  }


  public long getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(long productStatus) {
    this.productStatus = productStatus;
  }

}
