package org.taru.producttracing.pojo;


public class Batch {

  private String batchId;
  private String batchName;
  private String batchTime;
  private long batchStatus;
  private String batchQrcode;


  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }


  public String getBatchName() {
    return batchName;
  }

  public void setBatchName(String batchName) {
    this.batchName = batchName;
  }


  public String getBatchTime() {
    return batchTime;
  }

  public void setBatchTime(String batchTime) {
    this.batchTime = batchTime;
  }


  public long getBatchStatus() {
    return batchStatus;
  }

  public void setBatchStatus(long batchStatus) {
    this.batchStatus = batchStatus;
  }


  public String getBatchQrcode() {
    return batchQrcode;
  }

  public void setBatchQrcode(String batchQrcode) {
    this.batchQrcode = batchQrcode;
  }

}
