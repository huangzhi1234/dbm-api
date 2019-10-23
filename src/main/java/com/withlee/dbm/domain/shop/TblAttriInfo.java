package com.withlee.dbm.domain.shop;

public class TblAttriInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String attriId;
	private String attriName;
	private String productId;
	private String sort;
	private String attriOperId;
	private String attriValueDis;
	private String attriPrice;
	private String attriLevel;
	
	
	
	public String getAttriLevel() {
		return attriLevel;
	}
	public void setAttriLevel(String attriLevel) {
		this.attriLevel = attriLevel;
	}
	public String getAttriId() {
		return attriId;
	}
	public void setAttriId(String attriId) {
		this.attriId = attriId;
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

	public String getAttriOperId() {
		return attriOperId;
	}
	public void setAttriOperId(String attriOperId) {
		this.attriOperId = attriOperId;
	}
	public String getAttriValueDis() {
		return attriValueDis;
	}
	public void setAttriValueDis(String attriValueDis) {
		this.attriValueDis = attriValueDis;
	}
	public String getAttriPrice() {
		return attriPrice;
	}
	public void setAttriPrice(String attriPrice) {
		this.attriPrice = attriPrice;
	}
	
	
	
}
