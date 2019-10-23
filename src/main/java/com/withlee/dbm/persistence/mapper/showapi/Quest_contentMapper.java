package com.withlee.dbm.persistence.mapper.showapi;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.showapi.IPaper;
import com.withlee.dbm.domain.showapi.Iquest_content;


public interface Quest_contentMapper {
	
public List<Iquest_content>  getquest_content(@Param("questType") String questType);

	
	public int addquest_content(Iquest_content iquest_content);

}
