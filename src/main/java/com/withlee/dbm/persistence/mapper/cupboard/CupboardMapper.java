
package com.withlee.dbm.persistence.mapper.cupboard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.cupboard.TblAutoRepaly;
import com.withlee.dbm.domain.cupboard.TblClothingMatch;
import com.withlee.dbm.domain.cupboard.TblFashContent;
import com.withlee.dbm.domain.cupboard.TblNewInfo;
import com.withlee.dbm.domain.cupboard.TblScene;

/**
 * @desc 私人衣橱Mapper
 * @author linjiazhi
 * @since 2015年7月11日
 */
public interface CupboardMapper {

	/**
	 * 场景查询
	 */
	public List<TblScene> getScene(@Param("sceneId") Integer sceneId);

	/**
	 * 查询场景ID
	 */
	public Integer wordsFindSceneId(String words);

	/**
	 * 增加足迹
	 */
	public void addSpoor(TblClothingMatch tblClothingMatch);

	/**
	 * 查足迹列表-服装搭配
	 */
	public List<TblClothingMatch> getSpoor(Integer userId);

	/**
	 * 删除足迹-服装搭配
	 */
	public void delSpoor(Integer spoorId);

	/**
	 * 私人衣橱-查资讯
	 */
	public TblNewInfo getNewsInfo();

	/**
	 * 私人衣橱-引导语-个性化内容表
	 */
	public List<TblFashContent> getLead();

	/**
	 * 私人衣橱-引导语-自动回复
	 */
	public List<TblAutoRepaly> getAntoAnswer();

}
