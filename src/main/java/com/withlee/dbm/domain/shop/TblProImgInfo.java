package com.withlee.dbm.domain.shop;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

public class TblProImgInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String imgId;
	private String productId;
	private String attriId;
	private String imgName;
	@JsonSerialize(using = UrlSerializer.class)
	private String imgUrl;
	private String imgComment;
	private String imgType;

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAttriId() {
		return attriId;
	}

	public void setAttriId(String attriId) {
		this.attriId = attriId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgComment() {
		return imgComment;
	}

	public void setImgComment(String imgComment) {
		this.imgComment = imgComment;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	/*
	 * private String img_id; private String product_id; private String attri_id; private String img_name; private String img_url; private
	 * String img_comment; private String img_type;
	 */

}
