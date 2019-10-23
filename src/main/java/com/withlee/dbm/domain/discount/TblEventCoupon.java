package com.withlee.dbm.domain.discount;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @desc 活动优惠码关联信息
 * @table tbl_event_coupon
 * @author linjiazhi
 * @since 2015年7月31日
 */
public class TblEventCoupon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;// id

	private Integer eventId;// 活动id

	private String couponNum;// 活动id 优惠码/商品id/订单号/用户id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}