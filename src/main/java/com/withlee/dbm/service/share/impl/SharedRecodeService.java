package com.withlee.dbm.service.share.impl;

import com.withlee.dbm.domain.share.SharedRecord;
import com.withlee.dbm.persistence.mapper.share.SharedRecordMapper;
import com.withlee.dbm.service.share.ISharedRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zilongye on 15/9/5.
 */
@Service
public class SharedRecodeService implements ISharedRecordService {

    private static Logger log = LoggerFactory.getLogger(SharedRecodeService.class);

    @Autowired
    private SharedRecordMapper sharedRecordMapper;

    @Override
    public void addSharedRecode(SharedRecord sharedRecord) {
        sharedRecord.setCreateTime(new Date());
        sharedRecord.setUpdateTime(new Date());
        this.sharedRecordMapper.addSharedRecord(sharedRecord);
    }


}
