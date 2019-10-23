
package com.withlee.dbm.service.shop;

import java.util.List;

import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.shop.EcsGoodsAttr;
import com.withlee.dbm.domain.shop.Vo.ProLevelOneAttr;

public interface ShopService {

	/**
	 * 查询首页图片
	 */
	public String getHomePic();

	/**
	 * 查询商品类型
	 */
	@SuppressWarnings("rawtypes")
	public List getProductType();

	/**
	 * 查询商品列表
	 */
	public List<EcsGoods> getProductList(EcsGoods tblProductInfo);

	/**
	 * 获取商品一级属性
	 */
	public List<ProLevelOneAttr> getProLevelOneAttr(int productid);

	/**
	 * 获取商品所有属性
	 */
	public List<EcsGoodsAttr> getGoodsAttrlist(int productid);

}
