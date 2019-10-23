
package com.withlee.dbm.service.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.shop.EcsGoodsAttr;
import com.withlee.dbm.domain.shop.Vo.ProLevelOneAttr;
import com.withlee.dbm.persistence.mapper.shop.ShopMapper;
import com.withlee.dbm.service.shop.ShopService;

/**
 * @desc 用户模块ServiceImpl
 * @author linjiazhi
 * @since 2015年7月11日
 */
@Service
@Transactional
public class ShopImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 查询首页图片
	 */
	@Override
	public String getHomePic() {
		return this.shopMapper.getHomePic();
	}

	/**
	 * @desc 获取产品列表
	 * @since 2015年7月11日
	 */
	@Override
	public List<EcsGoods> getProductList(EcsGoods ecsGoods) {
		return this.shopMapper.getProductList(ecsGoods);
	}

	/***
	 * 查询商品类型
	 */
	@Override
	public List getProductType() {
		return this.shopMapper.getProductType();
	}

	/**
	 * 获取商品一级属性
	 */
	@Override
	public List<ProLevelOneAttr> getProLevelOneAttr(int productid) {
		return shopMapper.getProLevelOneAttr(productid);
	}

	/**
	 * 获取商品所有属性
	 */
	@Override
	public List<EcsGoodsAttr> getGoodsAttrlist(int productid) {
		return this.shopMapper.getGoodsAttrlist(productid);
	}

}
