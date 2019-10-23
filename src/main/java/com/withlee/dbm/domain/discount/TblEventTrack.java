package com.withlee.dbm.domain.discount;

import java.util.Date;

/**
 * @desc 活动跟踪信息
 * @table tbl_event_track
 * @author linjiazhi
 * @since 2015 年7月31日
 **/
public class TblEventTrack implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer trackId;// 主键id

	private Integer eventId;// 活动id

	private Integer orderId;// 订单号

	private Integer userId;// 使用人

	private Date createTime;// 使用时间

	private String couponNum;// 优惠码

	private double couponValue; // 优惠值(优惠了多少钱)

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}

	public double getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(double couponValue) {
		this.couponValue = couponValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
