package com.withlee.dbm.persistence.mapper.showapi;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.showapi.ITest3;

public interface Test3Mapper {
	
public List<ITest3>  getTest3(@Param("id") String id);
public int addTest3(ITest3 test3);

}
