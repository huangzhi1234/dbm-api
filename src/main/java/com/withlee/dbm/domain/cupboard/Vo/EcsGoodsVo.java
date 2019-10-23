package com.withlee.dbm.domain.cupboard.Vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

/*
 * 商品信息表
 * */
public class EcsGoodsVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/******** 商品列表所需字段 开始 ********/
	private Integer goodsId;// 商品ID(自动增长)
	private String goodsName;// 商品名称对应于 EcsGoodsType 的cat_name
	@JsonIgnore
	private String brandId;// 品牌id
	private double shopPrice;// 商品价格
	@JsonSerialize(using = UrlSerializer.class)
	private String goodsThumb;// 商品主图片 小图
	private String goodsDesc;// 商品描述
	@JsonIgnore
	private String brandName;// 品牌名称
	@JsonIgnore
	private Integer xiaoshou;// 销量

	private Integer sceneId;// 场景ID

	private String sceneName;// 场景名称
	@JsonSerialize(using = UrlSerializer.class)
	private String sceneImgUrl;// 明星URL,#号隔开
	/******** 商品列表所需字段 结束 ********/

	@JsonIgnore
	private int page;

	@JsonIgnore
	private int limit;

	@JsonIgnore
	private String goods_sn;// 商品编号
	@JsonIgnore
	private String goods_name_style;// 无效字段
	@JsonIgnore
	private String goods_number;// 商品数量
	@JsonIgnore
	private String market_price;// 市场价格
	@JsonIgnore
	private String warn_number;// 商品警告数量
	@JsonIgnore
	private String keywords;// 关键字
	@JsonIgnore
	private String goods_img;// 图片地址 （不用）
	@JsonIgnore
	private String original_img;// 原图片 大图
	@JsonIgnore
	private String is_on_sale;// 是否上架
	@JsonIgnore
	private String is_alone_sale;// 不用
	@JsonIgnore
	private String is_shipping;// ?
	@JsonIgnore
	private String is_male_dress;// 男装，女装?
	@JsonIgnore
	private String goods_type;// 商品类型 对应到 TblProductTypeInfo（对应旧表的ecshop.ecs_category）

	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	public String getSceneImgUrl() {
		return sceneImgUrl;
	}

	public void setSceneImgUrl(String sceneImgUrl) {
		this.sceneImgUrl = sceneImgUrl;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getGoodsThumb() {
		return goodsThumb;
	}

	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = goodsThumb;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getXiaoshou() {
		return xiaoshou;
	}

	public void setXiaoshou(Integer xiaoshou) {
		this.xiaoshou = xiaoshou;
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

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goods_sn) {
		this.goods_sn = goods_sn;
	}

	public String getGoods_name_style() {
		return goods_name_style;
	}

	public void setGoods_name_style(String goods_name_style) {
		this.goods_name_style = goods_name_style;
	}

	public String getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(String goods_number) {
		this.goods_number = goods_number;
	}

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getWarn_number() {
		return warn_number;
	}

	public void setWarn_number(String warn_number) {
		this.warn_number = warn_number;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public String getOriginal_img() {
		return original_img;
	}

	public void setOriginal_img(String original_img) {
		this.original_img = original_img;
	}

	public String getIs_on_sale() {
		return is_on_sale;
	}

	public void setIs_on_sale(String is_on_sale) {
		this.is_on_sale = is_on_sale;
	}

	public String getIs_alone_sale() {
		return is_alone_sale;
	}

	public void setIs_alone_sale(String is_alone_sale) {
		this.is_alone_sale = is_alone_sale;
	}

	public String getIs_shipping() {
		return is_shipping;
	}

	public void setIs_shipping(String is_shipping) {
		this.is_shipping = is_shipping;
	}

	public String getIs_male_dress() {
		return is_male_dress;
	}

	public void setIs_male_dress(String is_male_dress) {
		this.is_male_dress = is_male_dress;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		EcsGoodsVo that = (EcsGoodsVo) obj;
		return null != this.getGoodsId() && this.getGoodsId().equals(that.getGoodsId());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getGoodsId() ? 0 : getGoodsId().hashCode() * 31;
		return hashCode;
	}

}
