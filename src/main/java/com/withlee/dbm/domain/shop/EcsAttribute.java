package com.withlee.dbm.domain.shop;

/*
 *  属性表
 * */
public class EcsAttribute {
	private String attr_id;//属性ID
	private String cat_id;//对应于EcsGoodsType的cat_id
	private String attr_name;//属性名称  尺码
	private String attr_input_type;//不需要考虑
	private String attr_type;//单选|多选
	private String attr_values;//属性子集(尺码: s,l,x)
	private String attr_index;
	private String sort_order;//属性排序
	private String is_linked;
	private String attr_group;
	
	public String getAttr_id() {
		return attr_id;
	}
	public void setAttr_id(String attr_id) {
		this.attr_id = attr_id;
	}
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getAttr_name() {
		return attr_name;
	}
	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}
	public String getAttr_input_type() {
		return attr_input_type;
	}
	public void setAttr_input_type(String attr_input_type) {
		this.attr_input_type = attr_input_type;
	}
	public String getAttr_type() {
		return attr_type;
	}
	public void setAttr_type(String attr_type) {
		this.attr_type = attr_type;
	}
	public String getAttr_values() {
		return attr_values;
	}
	public void setAttr_values(String attr_values) {
		this.attr_values = attr_values;
	}
	public String getAttr_index() {
		return attr_index;
	}
	public void setAttr_index(String attr_index) {
		this.attr_index = attr_index;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	public String getIs_linked() {
		return is_linked;
	}
	public void setIs_linked(String is_linked) {
		this.is_linked = is_linked;
	}
	public String getAttr_group() {
		return attr_group;
	}
	public void setAttr_group(String attr_group) {
		this.attr_group = attr_group;
	}
	
	

}
