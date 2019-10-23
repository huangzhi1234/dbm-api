package com.withlee.dbm.service.invite.impl;

import com.withlee.dbm.domain.invite.InviteRecord;
import com.withlee.dbm.persistence.mapper.invite.InviteRecordMapper;
import com.withlee.dbm.service.invite.IInviteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zilongye on 15/9/6.
 */
@Service
public class InviteRecordService implements IInviteRecordService{

    @Autowired
    InviteRecordMapper inviteRecordMapper;

    @Override
    public int addInviteRecord(InviteRecord inviteRecord) {
        return this.inviteRecordMapper.addInviteRecord(inviteRecord);
    }
}
