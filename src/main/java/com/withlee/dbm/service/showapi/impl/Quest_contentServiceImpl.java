package com.withlee.dbm.service.showapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.Iquest_content;

import com.withlee.dbm.persistence.mapper.showapi.Quest_contentMapper;
import com.withlee.dbm.service.showapi.Quest_contentService;


@Service
@Transactional
public class Quest_contentServiceImpl implements Quest_contentService {
	
	@Autowired
	private Quest_contentMapper quest_contentMapper;

	@Override
	public List<Iquest_content> getquest_content(String questType) {
		// TODO Auto-generated method stub
		return quest_contentMapper.getquest_content(questType);
	}

	@Override
	public int addquest_content(Iquest_content iquest_content) {
		// TODO Auto-generated method stub
		return quest_contentMapper.addquest_content(iquest_content);
	}
	

}
