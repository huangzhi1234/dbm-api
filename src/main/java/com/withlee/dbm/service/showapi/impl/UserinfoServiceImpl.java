package com.withlee.dbm.service.showapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.IUserinfo;

import com.withlee.dbm.persistence.mapper.showapi.UserinfoMapper;
import com.withlee.dbm.service.showapi.UserinfoService;


@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {
	
	
	@Autowired
	private UserinfoMapper userinfoMapper;

	@Override
	public List<IUserinfo> getIUserinfo(String level) {
		// TODO Auto-generated method stub
		return userinfoMapper.getIUserinfo(level);
	}

	@Override
	public List<IUserinfo> getLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userinfoMapper.getLogin(username, password);
	}

}
