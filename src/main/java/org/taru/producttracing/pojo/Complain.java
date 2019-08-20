package org.taru.producttracing.pojo;


public class Complain {

  private String complainId;
  private String complainName;
  private String complainContent;
  private String complainUserId;
  private long complainStatus;


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

}
