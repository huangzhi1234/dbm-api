package com.withlee.dbm.persistence.mapper.showapi;

import java.util.List;


import org.apache.ibatis.annotations.Param;


import com.withlee.dbm.domain.showapi.Ianswer_content;



public interface Answer_contentMapper {
	
public List<Ianswer_content>  getanswer_content(@Param("questId") String questId);

	
	public int addanswer_content(Ianswer_content ianswer_content);

}
