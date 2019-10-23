
package com.withlee.dbm.persistence.mapper.discount;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.TblEventTrack;
import com.withlee.dbm.domain.discount.vo.CouponVo;

/**
 * @desc 优惠码Mapper
 * @author linjiazhi
 * @since 2015年7月11日
 */
public interface DisCountMapper {

	/**
	 * 校验优惠码是否存在&是否过期
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

	/**
	 * 更新优惠码使用状态
	 */
	public void updateCouponStatus(String couponNum);

	/**
	 * 根据用户id查询优惠码集合
	 * 
	 * @param userId
	 * @param status
	 * @return
	 */
	// List<TblEventCoupon> findByUserId(@Param("userId")Integer userId, @Param("status")Integer status);
	List<CouponVo> findByUserId(@Param("userId") Integer userId, @Param("status") Integer status);

	List<TblEventInfo> queryEventInfoAll();
}
