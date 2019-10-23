
package com.withlee.dbm.service.cupboard.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.cupboard.TblClothingMatch;
import com.withlee.dbm.persistence.mapper.cupboard.CupboardMapper;
import com.withlee.dbm.service.cupboard.CupboardService;

/**
 * @desc 私人衣橱ServiceImpl
 * @author linjiazhi
 * @since 2015年8月31日
 */
@Service
@Transactional
public class CupboardServiceImpl implements CupboardService {

	@Autowired
	private CupboardMapper cupboardMapper;

	@Override
	public void addSpoor(TblClothingMatch tblClothingMatch) {
		cupboardMapper.addSpoor(tblClothingMatch);
	}

	@Override
	public void delSpoor(Integer spoorId) {
		cupboardMapper.delSpoor(spoorId);
	}

}
