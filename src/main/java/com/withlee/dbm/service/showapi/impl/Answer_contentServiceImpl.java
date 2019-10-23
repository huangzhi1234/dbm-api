package com.withlee.dbm.service.showapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.showapi.Ianswer_content;
import com.withlee.dbm.persistence.mapper.showapi.Answer_contentMapper;
import com.withlee.dbm.service.showapi.Answer_contentService;

@Service
@Transactional
public class Answer_contentServiceImpl implements Answer_contentService {
	
	@Autowired
	private Answer_contentMapper answer_contentMapper;

	@Override
	public List<Ianswer_content> getanswer_content(String questId) {
		// TODO Auto-generated method stub
		return answer_contentMapper.getanswer_content(questId);
	}

	@Override
	public int addanswer_content(Ianswer_content ianswer_content) {
		// TODO Auto-generated method stub
		return answer_contentMapper.addanswer_content(ianswer_content);
	}

}
