package com.withlee.dbm.persistence.mapper.share;

import com.withlee.dbm.domain.share.SharedRecord;

/**
 * Created by zilongye on 15/9/5.
 */
public interface SharedRecordMapper {

    /**
     * 保存分享记录
     * @param sharedRecord
     */
    public void addSharedRecord(SharedRecord sharedRecord);


}
