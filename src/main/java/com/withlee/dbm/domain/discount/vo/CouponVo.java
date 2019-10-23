package com.withlee.dbm.domain.discount.vo;

import java.util.Date;

/**
 * Created by zilongye on 15/9/7.
 */
public class CouponVo {

	private String eventName;// 活动名称

	private String eventType;// 优惠类型

	private double amount;// 优惠值

	private String eventDisc;// 活动介绍

	private Date eventCreateTime;// 活动生效时间

	private Date eventEndTime;// 活动结束时间

	private Integer eventId;// 活动id

	private String couponNum;// 活动id 优惠码/商品id/订单号/用户id

	// 子龙把优惠码写在里面,活动写在外面,现在改造成全部放在一起,因为原因的缘故. change by lin 2015.9.14
	// List<TblEventCoupon> coupons; // 具体优惠码

	public String getEventName() {
		return eventName;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEventDisc() {
		return eventDisc;
	}

	public void setEventDisc(String eventDisc) {
		this.eventDisc = eventDisc;
	}

	public Date getEventCreateTime() {
		return eventCreateTime;
	}

	public void setEventCreateTime(Date eventCreateTime) {
		this.eventCreateTime = eventCreateTime;
	}

	public Date getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(Date eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	// public List<TblEventCoupon> getCoupons() {
	// return coupons;
	// }
	//
	// public void setCoupons(List<TblEventCoupon> coupons) {
	// this.coupons = coupons;
	// }
	//
	// public CouponVo(TblEventInfo tblEventInfo) {
	// this.eventName = tblEventInfo.getEventName();
	// this.eventType = tblEventInfo.getEventType();
	// this.amount = tblEventInfo.getAmount();
	// this.eventDisc = tblEventInfo.getEventDisc();
	// this.eventCreateTime = tblEventInfo.getEventCreateTime();
	// this.eventEndTime = tblEventInfo.getEventEndTime();
	// this.coupons = Lists.newArrayList();
	// }
}
