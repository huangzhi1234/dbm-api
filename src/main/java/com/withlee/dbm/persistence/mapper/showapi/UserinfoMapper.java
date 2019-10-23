package com.withlee.dbm.persistence.mapper.showapi;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.showapi.IUserinfo;


public interface UserinfoMapper {
	
	public List<IUserinfo>  getIUserinfo(@Param("level") String level);
	
	public List<IUserinfo> getLogin(@Param("username") String username,@Param("password") String password);
	
	

}
