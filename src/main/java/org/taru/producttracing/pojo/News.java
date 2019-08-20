package org.taru.producttracing.pojo;

public class News {

  private String newsId;
  private String newsName;
  private String newsContent;
  private String newsPhoto;
  private String newsTime;
  private long newsStatus;


  public String getNewsId() {
    return newsId;
  }

  public void setNewsId(String newsId) {
    this.newsId = newsId;
  }


  public String getNewsName() {
    return newsName;
  }

  public void setNewsName(String newsName) {
    this.newsName = newsName;
  }


  public String getNewsContent() {
    return newsContent;
  }

  public void setNewsContent(String newsContent) {
    this.newsContent = newsContent;
  }


  public String getNewsPhoto() {
    return newsPhoto;
  }

  public void setNewsPhoto(String newsPhoto) {
    this.newsPhoto = newsPhoto;
  }


  public String getNewsTime() {
    return newsTime;
  }

  public void setNewsTime(String newsTime) {
    this.newsTime = newsTime;
  }


  public long getNewsStatus() {
    return newsStatus;
  }

  public void setNewsStatus(long newsStatus) {
    this.newsStatus = newsStatus;
  }

}
