package com.withlee.dbm.domain.shop.Vo;

import java.util.ArrayList;
import java.util.List;

import com.withlee.dbm.domain.shop.EcsGoodsAttr;

public class ProDetailVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer attrId;

	private String attrName;

	private List<EcsGoodsAttr> attrivalue = new ArrayList();

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public List<EcsGoodsAttr> getAttrivalue() {
		return attrivalue;
	}

	public void setAttrivalue(List<EcsGoodsAttr> attrivalue) {
		this.attrivalue = attrivalue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
