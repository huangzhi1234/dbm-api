
package com.withlee.dbm.domain.order;

/**
 * @desc 订单产品信息表
 * @table tbl_order_product
 * @author linjiazhi
 * @since 2015年7月15日
 */
public class OrderProduct implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*********** 1. 订单商品子集所需4个字段 ************/
	private Integer productNum;// 产品数量
	private double totalPrice;// 总价格
	private Integer goodsId;// 产品ID
	private String proSize;// 尺码
	// @JsonSerialize(using = UrlSerializer.class)
	private String url;// 图片地址
	private String attrDesc;// 属性描述 以逗号隔开.
	private String goodsName;// 商品名称
	private double unitPrice;// 商品单价
	private String sceneName;// 场景名称
	/*********** 2. 订单商品表其他字段 ************/
	private Integer orderProductId;// 订单商品ID

	private Integer orderId;// 商品ID

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getOrderProductId() {
		return orderProductId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAttrDesc() {
		return attrDesc;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public void setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getProSize() {
		return proSize;
	}

	public void setProSize(String proSize) {
		this.proSize = proSize;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}