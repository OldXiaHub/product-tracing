package org.taru.producttracing.pojo;


public class Admin {

  private String adminId;
  private String adminName;
  private String adminPassword;
  private long adminStatus;
  private long adminFactoryStatus;


  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }


  public long getAdminStatus() {
    return adminStatus;
  }

  public void setAdminStatus(long adminStatus) {
    this.adminStatus = adminStatus;
  }


  public long getAdminFactoryStatus() {
    return adminFactoryStatus;
  }

  public void setAdminFactoryStatus(long adminFactoryStatus) {
    this.adminFactoryStatus = adminFactoryStatus;
  }

}
