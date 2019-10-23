package com.withlee.dbm.domain.share.vo;

import com.withlee.dbm.domain.share.SharedRecord;

import java.io.Serializable;

/**
 * Created by zilongye on 15/9/5.
 */
public class SharedRecordVo implements Serializable{

    public SharedRecordVo(){}

    private Integer userId;
    private String title;
    private String baseUrl;
    private String coverUrl;
    private String opinion;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }


    public SharedRecordVo(SharedRecord sharedRecord){
        this.userId = sharedRecord.getUserId();
        this.title = sharedRecord.getTitle();
        this.baseUrl = sharedRecord.getBaseUrl();
        this.coverUrl = sharedRecord.getCoverUrl();
        this.opinion = sharedRecord.getOpinion();
    }
}
