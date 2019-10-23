
package com.withlee.dbm.domain.order.vo;

import java.util.Date;
import java.util.List;

import com.withlee.dbm.domain.order.OrderAddress;
import com.withlee.dbm.domain.order.OrderProduct;

/**
 * 
 * @desc 该Vo仅用于查询订单详情,返回订单地址详细信息
 * @author linjiazhi
 * @since 2015年8月17日
 *
 */
public class OrderPlaceVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*********** 1. 商品下单接口所需参数 ************/
	private Integer userId;// 用户ID

	private double totalPrice;// 商品总价 （单位：元）

	private double price;// double 付款价格 （打折后的价格，单位：元）

	private String depiction;// 说明

	private OrderAddress addressInfo;// 收货详细信息

	private String orderProductName;// 产品名称

	private List<OrderProduct> orderProductList;// 商品子集(List)

	// 该字段是图片完整路径,无需加注解
	private String orderImgUrl;// 商品图片地址 多张图片用井号隔开,所以不用加注解.

	private String discountWay;// 打折方式 数据字典（使用优惠码，积分兑换，其他方式）

	private String discountCode;// 优惠码

	private int invoiceId;// 发票id ※此字段用于插发票表,不属于订单表字段

	private int dispatching;// 配送方式

	private int dispatchingType;// 配送时间 (1:任意时间,2:工作日,3:休息日)
	/*********** 2. 代码处理字段 ************/
	private Date orderTime;// 下单时间

	// 订单状态默认1:待付款;2:待发货（已付款）;3:已发货（等待收货）;4:已完成（已收货）;5:已取消;6:已退款;
	private Integer status;

	private String orderNum;// 订单号: 代码生成,生成策略由可读的当前时间戳+4位随机数

	/*********** 3. 后台选择物流和支付接口处理字段 ************/
	private Integer orderId;// 订单ID

	private String logisticsMode;// 物流方式 数据字典（顺丰，圆通，中通） ※该字段由后台设置

	private String logisticsNum;// 物流单号 ※该字段由后台设置

	private Integer payType;// 支付方式 数据字典（支付宝，财付通，微信支付，银联） ※该字段不在下单处理,由支付回调处理

	private Date payTime;// 付款时间 ※该字段由由支付回调处理

	private Date sendProductTime;// 发货时间 ※该字段由后台设置

	private Date endTime;// 完成时间 ※该字段由后台设置

	private Object logisticsInfo;// 物流详细信息

	public Object getLogisticsInfo() {
		return logisticsInfo;
	}

	public void setLogisticsInfo(Object logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}

	public int getDispatchingType() {
		return dispatchingType;
	}

	public void setDispatchingType(int dispatchingType) {
		this.dispatchingType = dispatchingType;
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

	public OrderAddress getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(OrderAddress addressInfo) {
		this.addressInfo = addressInfo;
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

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
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