
package com.withlee.dbm.persistence.mapper.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.cupboard.Vo.EcsGoodsVo;
import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.shop.EcsGoodsAttr;
import com.withlee.dbm.domain.shop.EcsGoodsGallery;
import com.withlee.dbm.domain.shop.Vo.ProLevelOneAttr;

public interface ShopMapper {

	/**
	 * 查询首页图片
	 */
	public String getHomePic();

	/************** 商品列表分页 **************/
	public List<EcsGoods> getProductList(EcsGoods ecsGoods);

	public int countProductList(EcsGoods ecsGoods);

	/************** 商品列表分页结束 **************/

	/**
	 * 查询商品类型
	 */
	public List getProductType();

	/**
	 * 获取商品一级属性
	 */
	public List<ProLevelOneAttr> getProLevelOneAttr(int productid);

	/**
	 * 获取商品所有属性
	 */
	public List<EcsGoodsAttr> getGoodsAttrlist(int productid);

	/**
	 * 获取商品展示厅(长图片)
	 */
	public List<EcsGoodsGallery> getGoodsPic(int productid);

	/**
	 * 获取单个商品信息
	 */
	public EcsGoods getSingleGoodsInfo(int productid);

	/**
	 * 获取商品信息列表(by sceneName场景名称)
	 */
	public List<EcsGoodsVo> getProductListByScene(@Param("userId") Integer userId, @Param("sceneName") String sceneName);

	/**
	 * 商品结果查询获取图片URL(2d/3d)
	 */
	public String get3dUrl(@Param("goods_id") Integer goods_id, @Param("specZheng") String specZheng);
}
