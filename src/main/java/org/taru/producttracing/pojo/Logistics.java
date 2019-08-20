package org.taru.producttracing.pojo;


public class Logistics {

  private String logisticsId;
  private String logisticsTime;
  private String logisticsStartAddress;
  private String logisticsEndAddress;
  private double logisticsStartGeo;
  private double logisticsEndGeo;


  public String getLogisticsId() {
    return logisticsId;
  }

  public void setLogisticsId(String logisticsId) {
    this.logisticsId = logisticsId;
  }


  public String getLogisticsTime() {
    return logisticsTime;
  }

  public void setLogisticsTime(String logisticsTime) {
    this.logisticsTime = logisticsTime;
  }


  public String getLogisticsStartAddress() {
    return logisticsStartAddress;
  }

  public void setLogisticsStartAddress(String logisticsStartAddress) {
    this.logisticsStartAddress = logisticsStartAddress;
  }


  public String getLogisticsEndAddress() {
    return logisticsEndAddress;
  }

  public void setLogisticsEndAddress(String logisticsEndAddress) {
    this.logisticsEndAddress = logisticsEndAddress;
  }


  public double getLogisticsStartGeo() {
    return logisticsStartGeo;
  }

  public void setLogisticsStartGeo(double logisticsStartGeo) {
    this.logisticsStartGeo = logisticsStartGeo;
  }


  public double getLogisticsEndGeo() {
    return logisticsEndGeo;
  }

  public void setLogisticsEndGeo(double logisticsEndGeo) {
    this.logisticsEndGeo = logisticsEndGeo;
  }

}
