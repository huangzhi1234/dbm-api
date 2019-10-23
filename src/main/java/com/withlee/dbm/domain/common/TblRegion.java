package com.withlee.dbm.domain.common;

/**
 * @desc 区域信息
 * @table tbl_region
 * @author linjiazhi
 * @since 2015年7月31日
 */
public class TblRegion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String code;// 编号

	private String province;// 省编号

	private String city;// 市编号

	private String district;// 区编号

	private String name;// 名字

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
