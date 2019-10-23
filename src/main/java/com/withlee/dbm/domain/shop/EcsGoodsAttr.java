package com.withlee.dbm.domain.shop;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

public class EcsGoodsAttr implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String goodsAttrId;
	private String goodsId;
	private Integer attrId;
	private String attrValue;
	private int attrPrice;
	@JsonSerialize(using = UrlSerializer.class)
	private String thumbUrl;
	@JsonSerialize(using = UrlSerializer.class)
	private String imgUrl;
	@JsonSerialize(using = UrlSerializer.class)
	private String imgOriginal;
	private String attrDesc;
	private String attrDisp;
	private String attrOrder;

	public String getGoodsAttrId() {
		return goodsAttrId;
	}

	public void setGoodsAttrId(String goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public int getAttrPrice() {
		return attrPrice;
	}

	public void setAttrPrice(int attrPrice) {
		this.attrPrice = attrPrice;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgOriginal() {
		return imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}

	public String getAttrDesc() {
		return attrDesc;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public String getAttrDisp() {
		return attrDisp;
	}

	public void setAttrDisp(String attrDisp) {
		this.attrDisp = attrDisp;
	}

	public String getAttrOrder() {
		return attrOrder;
	}

	public void setAttrOrder(String attrOrder) {
		this.attrOrder = attrOrder;
	}

}
