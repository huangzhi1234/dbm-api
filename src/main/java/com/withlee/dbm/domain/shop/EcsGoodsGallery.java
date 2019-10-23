package com.withlee.dbm.domain.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

public class EcsGoodsGallery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer imgId;

	private Integer goodsId;
	@JsonSerialize(using = UrlSerializer.class)
	private String imgUrl;

	@JsonIgnore
	private String imgDesc;
	@JsonSerialize(using = UrlSerializer.class)
	private String thumbUrl;
	@JsonSerialize(using = UrlSerializer.class)
	private String imgOriginal;

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getImgOriginal() {
		return imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
