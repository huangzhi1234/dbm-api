
package com.withlee.dbm.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.common.TblRegion;
import com.withlee.dbm.persistence.mapper.common.RegionMapper;
import com.withlee.dbm.service.common.RegionService;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionMapper regionMapper;

	@Override
	public List<TblRegion> getProvinceList() {
		// TODO Auto-generated method stub
		return regionMapper.getProvinceList();
	}

	@Override
	public List<TblRegion> getCityByProID(String province) {
		// TODO Auto-generated method stub
		return regionMapper.getCityByProID(province);
	}

	@Override
	public List<TblRegion> getDistrictByCityID(String province, String city) {
		// TODO Auto-generated method stub
		return regionMapper.getDistrictByCityID(province, city);
	}

}
