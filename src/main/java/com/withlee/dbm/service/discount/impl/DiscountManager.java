package com.withlee.dbm.service.discount.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.vo.CouponVo;
import com.withlee.dbm.service.discount.IDiscountManager;

/**
 * Created by zilongye on 15/9/7.
 */
@Service
public class DiscountManager implements IDiscountManager {

	@Override
	public Collection<CouponVo> mapper(List<TblEventInfo> tblEventInfos, List<TblEventCoupon> tblEventCoupons) {
		return null;
	}

	// @Override
	// public Collection<CouponVo> mapper(List<TblEventInfo> tblEventInfos,List<TblEventCoupon> tblEventCoupons) {
	// //放入map用于优惠码反查活动
	// Map<Integer,CouponVo> map = Maps.newHashMap();
	// for(TblEventInfo tblEventInfo : tblEventInfos){
	// CouponVo couponVo = new CouponVo(tblEventInfo);
	// map.put(tblEventInfo.getEventId(),couponVo);
	// }
	//
	// //存入map的vo中
	// for(TblEventCoupon tblEventCoupon : tblEventCoupons){
	// CouponVo couponVo = map.get(tblEventCoupon.getEventId());
	// couponVo.getCoupons().add(tblEventCoupon);
	// }
	//
	// return map.values();
	// }
}
