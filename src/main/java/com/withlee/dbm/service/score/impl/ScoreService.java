package com.withlee.dbm.service.score.impl;

import com.withlee.dbm.domain.score.Score;
import com.withlee.dbm.enums.ScoreType;
import com.withlee.dbm.persistence.mapper.score.ScoreMapper;
import com.withlee.dbm.service.score.IScoreService;
import com.withlee.dbm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Created by zilongye on 15/9/5.
 * 积分存取，暂时用crud,有时间重构成事件模型
 * TODO
 */
@Service
public class ScoreService implements IScoreService {


    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public boolean addScore(Integer userId, ScoreType scoreType, double scores) {
        Score score = new Score();
        score.setUserId(userId);
        score.setScore(scores);
        score.setScoreType(scoreType.value());
        score.setCreateTime(new Date());
        score.setUpdateTime(new Date());
        int scoreId = this.scoreMapper.addScore(score);
        Assert.notNull(scoreId, "[addScore] has error");
        return this.userService.addUserScore(userId, scores);
    }

    @Override
    public int count(Integer inviteUserId, ScoreType scoreType) {
        return scoreMapper.count(inviteUserId,scoreType.value());
    }

}
