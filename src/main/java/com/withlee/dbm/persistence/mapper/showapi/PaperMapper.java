package com.withlee.dbm.persistence.mapper.showapi;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.showapi.IPaper;


public interface PaperMapper {
	
public List<IPaper>  getPaper(@Param("paperType") String paperType);

	
	public int addPaper(IPaper ipaper);

}
