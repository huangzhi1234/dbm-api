package com.withlee.dbm.service.invite;

import com.withlee.dbm.domain.order.TblUserAddress;

/**
 * Created by zilongye on 15/9/6.
 */
public interface IReceiveService {

    /**
     * 邀请领取小礼品
     * @param inviteUserId
     * @param beInviteUserId
     * @param tblUserAddress
     */
    void receive(Integer inviteUserId, Integer beInviteUserId, TblUserAddress tblUserAddress);

    boolean exists(Integer userId);
}
