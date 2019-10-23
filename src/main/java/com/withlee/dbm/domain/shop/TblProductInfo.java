package com.withlee.dbm.domain.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

/**
 * TblProductInfo entity. @author MyEclipse Persistence Tools
 */

public class TblProductInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer productId;
	private String productNum;// 商品编号
	private String productName;// 商品名称
	private String productShopNum;// 商品货号
	private String productType;// 商品分类
	private String brand;// 商品品牌
	private Double price;// 本店售价
	@JsonSerialize(using = UrlSerializer.class)
	private String mainImgUrl;// 商品图片主图片
	@JsonSerialize(using = UrlSerializer.class)
	private String secondImgUrl;// 商品次要图片
	private Integer remainAmount;// 商品库存数量
	private Integer remainAlert;// 库存警告数量
	private String isAdded;// 是否上架
	private String isMale;// 是否男装
	private String proKeyword;// 商品关键词
	private String proDisc;// 商品描述
	private String isGood;// 是否是精品
	private String isNew;// 是否是新品
	private String isHot;// 是否热销
	private String createDate;// 创建时间
	private String createOper;// 创建人
	private double marketPrice;// 市场价格 add by lin 07.24
	private Integer saleNum;// 销售量 add by lin 07.24

	@JsonIgnore
	private int page;

	@JsonIgnore
	private int limit;

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/** default constructor */
	public TblProductInfo() {
	}

	/** minimal constructor */
	public TblProductInfo(String productNum, String productType) {
		this.productNum = productNum;
		this.productType = productType;
	}

	/** full constructor */
	public TblProductInfo(String productNum, String productName, String productShopNum, String productType, String brand, Double price,
			String mainImgUrl, String secondImgUrl, Integer remainAmount, Integer remainAlert, String isAdded, String isMale,
			String proKeyword, String proDisc, String isGood, String isNew, String isHot, String createDate, String createOper) {
		this.productNum = productNum;
		this.productName = productName;
		this.productShopNum = productShopNum;
		this.productType = productType;
		this.brand = brand;
		this.price = price;
		this.mainImgUrl = mainImgUrl;
		this.secondImgUrl = secondImgUrl;
		this.remainAmount = remainAmount;
		this.remainAlert = remainAlert;
		this.isAdded = isAdded;
		this.isMale = isMale;
		this.proKeyword = proKeyword;
		this.proDisc = proDisc;
		this.isGood = isGood;
		this.isNew = isNew;
		this.isHot = isHot;
		this.createDate = createDate;
		this.createOper = createOper;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductNum() {
		return this.productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShopNum() {
		return this.productShopNum;
	}

	public void setProductShopNum(String productShopNum) {
		this.productShopNum = productShopNum;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMainImgUrl() {
		return this.mainImgUrl;
	}

	public void setMainImgUrl(String mainImgUrl) {
		this.mainImgUrl = mainImgUrl;
	}

	public String getSecondImgUrl() {
		return this.secondImgUrl;
	}

	public void setSecondImgUrl(String secondImgUrl) {
		this.secondImgUrl = secondImgUrl;
	}

	public Integer getRemainAmount() {
		return this.remainAmount;
	}

	public void setRemainAmount(Integer remainAmount) {
		this.remainAmount = remainAmount;
	}

	public Integer getRemainAlert() {
		return this.remainAlert;
	}

	public void setRemainAlert(Integer remainAlert) {
		this.remainAlert = remainAlert;
	}

	public String getIsAdded() {
		return this.isAdded;
	}

	public void setIsAdded(String isAdded) {
		this.isAdded = isAdded;
	}

	public String getIsMale() {
		return this.isMale;
	}

	public void setIsMale(String isMale) {
		this.isMale = isMale;
	}

	public String getProKeyword() {
		return this.proKeyword;
	}

	public void setProKeyword(String proKeyword) {
		this.proKeyword = proKeyword;
	}

	public String getProDisc() {
		return this.proDisc;
	}

	public void setProDisc(String proDisc) {
		this.proDisc = proDisc;
	}

	public String getIsGood() {
		return this.isGood;
	}

	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}

	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getIsHot() {
		return this.isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateOper() {
		return this.createOper;
	}

	public void setCreateOper(String createOper) {
		this.createOper = createOper;
	}

}