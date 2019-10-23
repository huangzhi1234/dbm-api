package com.withlee.dbm.service.showapi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.IRegister;
import com.withlee.dbm.persistence.mapper.showapi.RegisterMapper;
import com.withlee.dbm.service.showapi.RegisterService;


@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public int addRegister(IRegister iregister) {
		// TODO Auto-generated method stub
		return registerMapper.addIRegister(iregister);
	}

}
