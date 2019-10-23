
package com.withlee.dbm.service.cupboard;

import com.withlee.dbm.domain.cupboard.TblClothingMatch;

/**
 * @desc 私人衣橱Service
 * @author linjiazhi
 * @since 2015年8月31日
 */
public interface CupboardService {

	/**
	 * 增加足迹
	 */
	public void addSpoor(TblClothingMatch tblClothingMatch);

	/**
	 * 删除足迹-服装搭配
	 */
	public void delSpoor(Integer spoorId);

}
