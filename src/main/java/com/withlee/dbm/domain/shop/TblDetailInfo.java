package com.withlee.dbm.domain.shop;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

public class TblDetailInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer attriId;// 属性id
	@JsonSerialize(using = UrlSerializer.class)
	private String imgUrl; // 属性图片url 关联的素材url组合
	@JsonSerialize(using = UrlSerializer.class)
	private String imgSmallUrl;// 属性缩略图url
	private String attriName;// 属性名称
	private String productId;// 所属商品编号
	private String sort;// 排序位置
	private Integer attriOperId;// 父属性id
	private String attriValueDis;// 属性描述
	private double attriPrice;// 价格
	private String attriLevel;// 属性级别

	public Integer getAttriId() {
		return attriId;
	}

	public void setAttriId(Integer attriId) {
		this.attriId = attriId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgSmallUrl() {
		return imgSmallUrl;
	}

	public void setImgSmallUrl(String imgSmallUrl) {
		this.imgSmallUrl = imgSmallUrl;
	}

	public String getAttriName() {
		return attriName;
	}

	public void setAttriName(String attriName) {
		this.attriName = attriName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getAttriOperId() {
		return attriOperId;
	}

	public void setAttriOperId(Integer attriOperId) {
		this.attriOperId = attriOperId;
	}

	public String getAttriValueDis() {
		return attriValueDis;
	}

	public void setAttriValueDis(String attriValueDis) {
		this.attriValueDis = attriValueDis;
	}

	public double getAttriPrice() {
		return attriPrice;
	}

	public void setAttriPrice(double attriPrice) {
		this.attriPrice = attriPrice;
	}

	public String getAttriLevel() {
		return attriLevel;
	}

	public void setAttriLevel(String attriLevel) {
		this.attriLevel = attriLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
