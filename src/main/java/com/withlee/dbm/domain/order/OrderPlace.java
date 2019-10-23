
package com.withlee.dbm.domain.order;

import java.util.Date;
import java.util.List;

/**
 * @desc 商品下单接口
 * @table tbl_order_info
 * @author linjiazhi
 * @since 2015年7月15日
 */
public class OrderPlace implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*********** 1. 商品下单接口所需参数 ************/
	private Integer userId;// 用户ID

	private double totalPrice;// 商品总价 （单位：元）

	private double price;// double 付款价格 （打折后的价格，单位：元）

	private String depiction;// 说明

	private Integer addressId;// 收货信息ID

	private String orderProductName;// 产品名称

	private List<OrderProduct> orderProductList;// 商品子集(List)

	// 该字段是图片完整路径,无需加注解
	private String orderImgUrl;// 商品图片地址

	private int invoiceId;// 发票id ※此字段用于插发票表,不属于订单表字段

	private int dispatching;// 配送方式

	private int dispatchingType;// 配送时间 (1:任意时间,2:工作日,3:休息日)

	/*********** 2. 优惠码所需字段 ************/
	private String discountWay;// 打折方式 数据字典（1:抵现金,2:打折）

	private String discountCode;// 优惠码

	private Integer eventId;// 活动id

	private String couponNum;// 优惠码 用于插入跟踪表

	private double couponValue; // 优惠值(优惠了多少钱)
	/*********** 3. 代码处理字段 ************/
	private Date orderTime;// 下单时间

	// 订单状态默认1:待付款;2:待发货（已付款）;3:已发货（等待收货）;4:已完成（已收货）;5:已取消;6:已退款;
	private Integer status;

	private String orderNum;// 订单号: 代码生成,生成策略由可读的当前时间戳+4位随机数

	/*********** 4. 后台选择物流和支付接口处理字段 ************/
	private Integer orderId;// 订单ID

	private String logisticsMode;// 物流方式 数据字典（顺丰，圆通，中通） ※该字段由后台设置

	private String logisticsNum;// 物流单号 ※该字段由后台设置

	private int payType;// 支付方式 数据字典（支付宝，财付通，微信支付，银联） ※该字段不在下单处理,由支付回调处理

	private Date payTime;// 付款时间 ※该字段由由支付回调处理

	private Date sendProductTime;// 发货时间 ※该字段由后台设置

	private Date endTime;// 完成时间 ※该字段由后台设置

	private String orderFrom;// 订单来源

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepiction() {
		return depiction;
	}

	public void setDepiction(String depiction) {
		this.depiction = depiction;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getOrderProductName() {
		return orderProductName;
	}

	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public String getOrderImgUrl() {
		return orderImgUrl;
	}

	public void setOrderImgUrl(String orderImgUrl) {
		this.orderImgUrl = orderImgUrl;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getDispatching() {
		return dispatching;
	}

	public void setDispatching(int dispatching) {
		this.dispatching = dispatching;
	}

	public int getDispatchingType() {
		return dispatchingType;
	}

	public void setDispatchingType(int dispatchingType) {
		this.dispatchingType = dispatchingType;
	}

	public String getDiscountWay() {
		return discountWay;
	}

	public void setDiscountWay(String discountWay) {
		this.discountWay = discountWay;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
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

	public double getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(double couponValue) {
		this.couponValue = couponValue;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getLogisticsMode() {
		return logisticsMode;
	}

	public void setLogisticsMode(String logisticsMode) {
		this.logisticsMode = logisticsMode;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getSendProductTime() {
		return sendProductTime;
	}

	public void setSendProductTime(Date sendProductTime) {
		this.sendProductTime = sendProductTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}