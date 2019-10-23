
package com.withlee.dbm.service.discount.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.TblEventTrack;
import com.withlee.dbm.domain.discount.vo.CouponVo;
import com.withlee.dbm.persistence.mapper.discount.DisCountMapper;
import com.withlee.dbm.service.discount.DiscountService;

/**
 * @desc 用户模块ServiceImpl
 * @author linjiazhi
 * @since 2015年7月11日
 */
@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DisCountMapper disCountMapper;

	@Override
	public TblEventCoupon checkCouponExist(String couponNum) {
		return disCountMapper.checkCouponExist(couponNum);
	}

	@Override
	public int checkCouponUsed(String couponNum) {
		return disCountMapper.checkCouponUsed(couponNum);
	}

	@Override
	public TblEventInfo queryEventInfo(int eventId) {
		return disCountMapper.queryEventInfo(eventId);
	}

	@Override
	public int addTblEventTrack(TblEventTrack tblEventTrack) {
		return disCountMapper.addTblEventTrack(tblEventTrack);
	}

	@Override
	public List<TblEventInfo> queryEventInfoAll() {
		return disCountMapper.queryEventInfoAll();
	}

	// @Override
	// public List<TblEventCoupon> findByUserId(Integer userId, Integer status) {
	// return disCountMapper.findByUserId(userId,status);
	// }

	@Override
	public List<CouponVo> findByUserId(Integer userId, Integer status) {
		return disCountMapper.findByUserId(userId, status);
	}
}
