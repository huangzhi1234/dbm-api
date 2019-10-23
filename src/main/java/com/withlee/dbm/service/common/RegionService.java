
package com.withlee.dbm.service.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.common.TblRegion;

public interface RegionService {

	/**
	 * 查询全部省
	 */
	public List<TblRegion> getProvinceList();

	/**
	 * 根据省查询市
	 */
	public List<TblRegion> getCityByProID(String province);

	/**
	 * 根据市查区
	 */
	public List<TblRegion> getDistrictByCityID(@Param("province") String province, @Param("city") String city);

}
