package com.withlee.dbm.persistence.mapper.showapi;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.showapi.IRegister;


public interface RegisterMapper {
	
	public int addIRegister(IRegister iregister);
	
	public IRegister findByInvitationId(@Param("id")Integer id);

}
