package com.withlee.dbm.domain.share;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zilongye on 15/9/5.
 */
public class SharedRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    public SharedRecord(){}

    private Integer id;
    private Integer userId;
    private String shareDevice;
    private String title;
    private String baseUrl;
    private String coverUrl;
    private String opinion;
    private Integer shareType;// -> ShareType
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShareDevice() {
        return shareDevice;
    }

    public void setShareDevice(String shareDevice) {
        this.shareDevice = shareDevice;
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

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
