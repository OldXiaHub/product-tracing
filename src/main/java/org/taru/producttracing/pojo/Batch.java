package org.taru.producttracing.pojo;


import java.sql.Blob;

public class Batch {

    private String batchId;
    private String batchName;
    private String batchTime;
    private Integer batchStatus;
    private Blob batchQrcode;
    private String batchProductId;
    private String batchProductName;
    private String batchProductPhoto;
    private String batchProductComment;
    private String batchProductCreateTime;
    private String batchProductQualityTime;
    private String batchFactoryId;
    private double batchStartGeo;
    private double batchEndGeo;


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


    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
    }


    public Blob getBatchQrcode() {
        return batchQrcode;
    }

    public void setBatchQrcode(Blob batchQrcode) {
        this.batchQrcode = batchQrcode;
    }


    public String getBatchProductId() {
        return batchProductId;
    }

    public void setBatchProductId(String batchProductId) {
        this.batchProductId = batchProductId;
    }


    public String getBatchProductName() {
        return batchProductName;
    }

    public void setBatchProductName(String batchProductName) {
        this.batchProductName = batchProductName;
    }


    public String getBatchProductPhoto() {
        return batchProductPhoto;
    }

    public void setBatchProductPhoto(String batchProductPhoto) {
        this.batchProductPhoto = batchProductPhoto;
    }


    public String getBatchProductComment() {
        return batchProductComment;
    }

    public void setBatchProductComment(String batchProductComment) {
        this.batchProductComment = batchProductComment;
    }


    public String getBatchProductCreateTime() {
        return batchProductCreateTime;
    }

    public void setBatchProductCreateTime(String batchProductCreateTime) {
        this.batchProductCreateTime = batchProductCreateTime;
    }


    public String getBatchProductQualityTime() {
        return batchProductQualityTime;
    }

    public void setBatchProductQualityTime(String batchProductQualityTime) {
        this.batchProductQualityTime = batchProductQualityTime;
    }


    public String getBatchFactoryId() {
        return batchFactoryId;
    }

    public void setBatchFactoryId(String batchFactoryId) {
        this.batchFactoryId = batchFactoryId;
    }


    public double getBatchStartGeo() {
        return batchStartGeo;
    }

    public void setBatchStartGeo(double batchStartGeo) {
        this.batchStartGeo = batchStartGeo;
    }


    public double getBatchEndGeo() {
        return batchEndGeo;
    }

    public void setBatchEndGeo(double batchEndGeo) {
        this.batchEndGeo = batchEndGeo;
    }

}
