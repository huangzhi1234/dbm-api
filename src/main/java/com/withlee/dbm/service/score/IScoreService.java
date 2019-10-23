package com.withlee.dbm.service.score;

import com.withlee.dbm.enums.ScoreType;

/**
 * Created by zilongye on 15/9/5.
 */
public interface IScoreService {

    boolean addScore(Integer userId, ScoreType scoreType, double score);


    int count(Integer inviteUserId, ScoreType scoreType);
}
