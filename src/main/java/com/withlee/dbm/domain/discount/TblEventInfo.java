package com.withlee.dbm.domain.discount;

import java.util.Date;

/**
 * @desc 优惠活动表
 * @table tbl_event_info
 * @author linjiazhi
 * @since 2015年7月31日
 */
public class TblEventInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer eventId;// id

	private String eventName;// 活动名称

	private Integer count;// 发放个数

	private String eventType;// 优惠类型

	private double amount;// 优惠值

	private String sendType;// 发放方式

	private String eventDisc;// 活动介绍

	private Date eventCreateTime;// 活动生效时间

	private Date eventEndTime;// 活动结束时间

	private Integer eventEndTimestamp;// 活动结束时间戳

	private String creator;// 活动创建人

	private double orderValueDown;// 订单金额下限

	private double orderValueUp;// 订单金额上限

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
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

	public Integer getEventEndTimestamp() {
		return eventEndTimestamp;
	}

	public void setEventEndTimestamp(Integer eventEndTimestamp) {
		this.eventEndTimestamp = eventEndTimestamp;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public double getOrderValueDown() {
		return orderValueDown;
	}

	public void setOrderValueDown(double orderValueDown) {
		this.orderValueDown = orderValueDown;
	}

	public double getOrderValueUp() {
		return orderValueUp;
	}

	public void setOrderValueUp(double orderValueUp) {
		this.orderValueUp = orderValueUp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
