package com.withlee.dbm.service.showapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.ITest3;
import com.withlee.dbm.persistence.mapper.showapi.Test3Mapper;
import com.withlee.dbm.service.showapi.Test3Service;

@Service
@Transactional
public class Test3ServiceImpl implements Test3Service {
	
	
	@Autowired
	private Test3Mapper test3Mapper;

	@Override
	public List<ITest3> getTest3(String id) {
		// TODO Auto-generated method stub
		return test3Mapper.getTest3(id);
	}

	@Override
	public int addTest3(ITest3 test3) {
		// TODO Auto-generated method stub
		return test3Mapper.addTest3(test3);
	}

	

}
