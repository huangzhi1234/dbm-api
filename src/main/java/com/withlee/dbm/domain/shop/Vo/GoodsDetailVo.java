package com.withlee.dbm.domain.shop.Vo;

import java.util.List;

import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.shop.EcsGoodsGallery;

public class GoodsDetailVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private EcsGoods info;// 商品信息

	private List<ProDetailVo> spec;// 商品属性

	private List<EcsGoodsGallery> showingPic;// 展示厅

	public EcsGoods getInfo() {
		return info;
	}

	public void setInfo(EcsGoods info) {
		this.info = info;
	}

	public List<ProDetailVo> getSpec() {
		return spec;
	}

	public void setSpec(List<ProDetailVo> spec) {
		this.spec = spec;
	}

	public List<EcsGoodsGallery> getShowingPic() {
		return showingPic;
	}

	public void setShowingPic(List<EcsGoodsGallery> showingPic) {
		this.showingPic = showingPic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
