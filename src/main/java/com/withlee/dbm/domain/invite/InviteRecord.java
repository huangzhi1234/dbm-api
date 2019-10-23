package com.withlee.dbm.domain.invite;

import java.util.Date;

/**
 * Created by zilongye on 15/9/6.
 */
public class InviteRecord {

    private Integer id;
    private Integer inviterId;//邀请者的userId
    private Integer inviteeId;//被邀请者的userId
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public Integer getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(Integer inviteeId) {
        this.inviteeId = inviteeId;
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

    public InviteRecord(Integer inviterId, Integer inviteeId) {
        this.inviterId = inviterId;
        this.inviteeId = inviteeId;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
