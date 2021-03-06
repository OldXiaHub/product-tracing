package org.taru.producttracing.pojo;


public class Complain {

  private String complainId;
  private String complainName;
  private String complainContent;
  private String complainPhoto;
  private String complainUserId;
  private long complainStatus;
  private String complainTime;
  private String complainUserTelphone;
  private String complainBatchBarcode;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  private User user;

  public String getComplainId() {
    return complainId;
  }

  public void setComplainId(String complainId) {
    this.complainId = complainId;
  }


  public String getComplainName() {
    return complainName;
  }

  public void setComplainName(String complainName) {
    this.complainName = complainName;
  }


  public String getComplainContent() {
    return complainContent;
  }

  public void setComplainContent(String complainContent) {
    this.complainContent = complainContent;
  }


  public String getComplainPhoto() {
    return complainPhoto;
  }

  public void setComplainPhoto(String complainPhoto) {
    this.complainPhoto = complainPhoto;
  }


  public String getComplainUserId() {
    return complainUserId;
  }

  public void setComplainUserId(String complainUserId) {
    this.complainUserId = complainUserId;
  }


  public long getComplainStatus() {
    return complainStatus;
  }

  public void setComplainStatus(long complainStatus) {
    this.complainStatus = complainStatus;
  }


  public String getComplainTime() {
    return complainTime;
  }

  public void setComplainTime(String complainTime) {
    this.complainTime = complainTime;
  }


  public String getComplainUserTelphone() {
    return complainUserTelphone;
  }

  public void setComplainUserTelphone(String complainUserTelphone) {
    this.complainUserTelphone = complainUserTelphone;
  }


  public String getComplainBatchBarcode() {
    return complainBatchBarcode;
  }

  public void setComplainBatchBarcode(String complainBatchBarcode) {
    this.complainBatchBarcode = complainBatchBarcode;
  }

}
