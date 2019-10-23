package com.withlee.dbm.service.invite.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.withlee.dbm.Settings;
import com.withlee.dbm.domain.invite.InviteRecord;
import com.withlee.dbm.domain.order.TblUserAddress;
import com.withlee.dbm.enums.ScoreType;
import com.withlee.dbm.service.invite.IInviteRecordService;
import com.withlee.dbm.service.order.AddressService;
import com.withlee.dbm.service.score.IScoreService;
import com.withlee.dbm.service.invite.IReceiveService;
import com.withlee.dbm.service.share.impl.SharedRecodeService;
import com.withlee.dbm.util.callhttp.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Created by zilongye on 15/9/6.
 */
@Service
public class ReceiveService implements IReceiveService {

    private static Logger log = LoggerFactory.getLogger(SharedRecodeService.class);

    @Autowired
    private IScoreService scoreService;
    @Autowired
    private IInviteRecordService inviteRecordService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private Settings settings;

    private Map<String, String> headers = ImmutableMap.of("Content-type", "");


    @Override
    @Transactional
    public void receive(Integer inviteUserId, Integer beInviteUserId,TblUserAddress tblUserAddress) {

        addressService.addAddress(tblUserAddress);
        Assert.notNull(tblUserAddress.getAddressId(),"[addAddress] - fail addressId is null");

        //添加积分
        boolean addScoreResult = scoreService.addScore(inviteUserId, ScoreType.EVENT, 1);
        Assert.isTrue(addScoreResult, "[invitation] - fail");

        //增加邀请成功记录
        Integer id = inviteRecordService.addInviteRecord(new InviteRecord(inviteUserId,beInviteUserId));
        Assert.notNull(id,"[addInviteRecord] - fail");

        //邀请人请求后台api领取优惠码
        JSONObject data = (JSONObject) HttpUtils.doAsyncPost(settings.ADMIN_API + "mgr/discount/bind", headers,
                ImmutableMap.of("user_id", inviteUserId.toString()), null);
        Assert.isTrue(data.getBoolean("result"), "[createDiscount] - fail data is :" + data);

        //被邀请人请求后台api领取小礼品
        boolean result = receiveGift(beInviteUserId, tblUserAddress.getAddressId());
        Assert.isTrue(result, "[receiveGift] - fail receive record is exists");
    }

    @Override
    public boolean exists(Integer userId) {
        JSONObject result = (JSONObject) HttpUtils.doAsyncGet(settings.ADMIN_API + "mgr/gift/order/receive?user_id=" + userId);
        return result.getBoolean("result");
    }


    private boolean receiveGift(Integer beInviteUserId, Integer addressId) {
        JSONObject result = (JSONObject) HttpUtils.doAsyncPost(settings.ADMIN_API + "mgr/gift/order/receive", headers,
                ImmutableMap.of("user_id", beInviteUserId.toString(), "address_id", addressId.toString()), null);
        return result.getBoolean("result");
    }
}
