package com.withlee.dbm.persistence.mapper.score;

import com.withlee.dbm.domain.score.Score;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zilongye on 15/9/5.
 */
public interface ScoreMapper {

    public int addScore(Score score);

    int count(@Param("userId") Integer userId, @Param("scoreType") int scoreType);
}
