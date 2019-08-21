package org.taru.producttracing.pojo;


public class User {

  private String userId;
  private String nickName;
  private String userPassword;
  private String userTelphone;
  private String userAddress;
  private String userComment;
  private long userStatus;
  private String avatarUrl;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return nickName;
  }

  public void setUserName(String nickName) {
    this.nickName = nickName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserTelphone() {
    return userTelphone;
  }

  public void setUserTelphone(String userTelphone) {
    this.userTelphone = userTelphone;
  }


  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }


  public String getUserComment() {
    return userComment;
  }

  public void setUserComment(String userComment) {
    this.userComment = userComment;
  }


  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }


  public String getUserUrl() {
    return avatarUrl;
  }

  public void setUserUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

}
