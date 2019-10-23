
package com.withlee.dbm.service.discount;

import java.util.List;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.TblEventTrack;
import com.withlee.dbm.domain.discount.vo.CouponVo;

/**
 * @desc 用户模块Service
 * @author linjiazhi
 * @since 2015年7月11日
 */
public interface DiscountService {

	/**
	 * 检查优惠码是否存在
	 */
	public TblEventCoupon checkCouponExist(String couponNum);

	/**
	 * 检查优惠码是否使用
	 */
	public int checkCouponUsed(String couponNum);

	/**
	 * 查询优惠活动信息
	 */
	public TblEventInfo queryEventInfo(int eventId);

	/**
	 * 插入优惠活动使用信息
	 */
	public int addTblEventTrack(TblEventTrack tblEventTrack);

	List<TblEventInfo> queryEventInfoAll();

	/**
	 * 根据用户id查询其拥有的优惠码
	 * 
	 * @param userId
	 * @param status
	 *            使用状态
	 * @return
	 */
	// List<TblEventCoupon> findByUserId(Integer userId,Integer status);
	List<CouponVo> findByUserId(Integer userId, Integer status);
}
