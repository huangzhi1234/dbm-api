package com.withlee.dbm.domain.shop;

//商品类型表（一个商品一个类型）
/*
 *  这里是整个流程的入口
 *  1. 向  EcsGoodsType 表中增加一个产品类型
 *  2. 为该类型在EcsAttribute表中增加属性，关联关系为(EcsGoodsType.cat_id =
 *     EcsAttribute.cat_id)
 *  3. 为该类型在EcsGoods增加一个产品，关联关系为(EcsGoodsType.cat_name = EcsGoods.goods_name)
 *  4. 把产品和属性进行关联 (在EcsGoodsAttr中增加数据) 关联关系为 EcsGoodsAttr.goods_id
 *     =EcsGoods.goods_id
 *  5. 合成图片保存合成结果到 EcsSpecImage，EcsSpecFile
 * */
public class EcsGoodsType {
	private int catId;// 商品ID
	private String catName;// 商品名称
	private String enabled;// 是否启用
	private String attrGroup;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getAttrGroup() {
		return attrGroup;
	}

	public void setAttrGroup(String attrGroup) {
		this.attrGroup = attrGroup;
	}

}
