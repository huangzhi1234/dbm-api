package com.withlee.dbm.service.showapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.IPaper;
import com.withlee.dbm.persistence.mapper.showapi.PaperMapper;
import com.withlee.dbm.service.showapi.PaperService;


@Service
@Transactional
public class PaperServiceImpl implements PaperService {
	
	
	@Autowired
	private PaperMapper paperMapper;
	

	@Override
	public List<IPaper> getIPaper(String paperType) {
		// TODO Auto-generated method stub
		return paperMapper.getPaper(paperType);
	}

	@Override
	public int addIPaper(IPaper ipaper) {
		// TODO Auto-generated method stub
		return paperMapper.addPaper(ipaper);
	}
	
	
}
